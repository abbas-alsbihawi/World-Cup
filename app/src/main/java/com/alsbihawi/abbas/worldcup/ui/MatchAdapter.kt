package com.alsbihawi.abbas.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alsbihawi.abbas.worldcup.R
import com.alsbihawi.abbas.worldcup.data.domain.Match
import com.alsbihawi.abbas.worldcup.databinding.ItemMatchBinding
import com.alsbihawi.abbas.worldcup.databinding.ItemMatchHeaderBinding

class MatchAdapter(private var list: List<Match>, private val listener: MatchInteractionListener):RecyclerView.Adapter<MatchAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType){
            TYPE_VIEW_HEADER->{
                val view= LayoutInflater.from(parent.context).inflate(R.layout.item_match_header,parent,false)
                return HeaderViewHolder(view)
            }
            TYPE_VIEW_MATCH->{
                val view= LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
                return MatchViewHolder(view)
                }
        }
      return super.createViewHolder(parent,viewType)
    }

    override fun getItemCount()= list.size


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentMatch=list[position]
        when(holder){
           is MatchViewHolder ->{
               holder.binding.apply {
                   textHomeTeamName.text=currentMatch.homeTeamName
                   textAwayTeamName.text=currentMatch.awayTeamName
                   textHomeTeamGoals.text=currentMatch.homeTeamGoals.toString()
                   textAwayTeamGoals.text=currentMatch.awayTeamGoals.toString()
                   textYear.text=currentMatch.year.toString()
                   textHomeTeamName.setOnClickListener { listener.onClickTeamName(currentMatch.homeTeamName) }
                   textAwayTeamName.setOnClickListener { listener.onClickTeamName(currentMatch.awayTeamName) }
                   root.setOnClickListener { listener.onClickItem(currentMatch) }
                   iconDelete.setOnClickListener { listener.deleteAtItem(position) }


                   if (currentMatch.homeTeamGoals>currentMatch.awayTeamGoals){
                       textHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.teal_200))
                       textAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))
                   } else if (currentMatch.homeTeamGoals<currentMatch.awayTeamGoals){
                       textHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))
                       textAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.teal_200))
                   }else{
                       textHomeTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))
                       textAwayTeamGoals.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.purple_500))

                   }
               }
           }
            is  HeaderViewHolder->{

            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position==0)  TYPE_VIEW_HEADER  else TYPE_VIEW_MATCH
    }

    fun setList(newList: List<Match>){
        val diffUtil=DiffUtil.calculateDiff(MatchDiffUtil(list,newList))
        list=newList
        diffUtil.dispatchUpdatesTo(this)
     }


   abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
     class MatchViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding= ItemMatchBinding.bind(itemView)
    }
    class HeaderViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding= ItemMatchHeaderBinding.bind(itemView)
    }
    companion object{
        const val TYPE_VIEW_HEADER=11
        const val  TYPE_VIEW_MATCH=12
    }
}