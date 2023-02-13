package com.alsbihawi.abbas.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alsbihawi.abbas.worldcup.R
import com.alsbihawi.abbas.worldcup.data.domain.Match
import com.alsbihawi.abbas.worldcup.databinding.ItemMatchBinding

class MatchAdapter(private val list: List<Match>,val listener: MatchInteractionListener):RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_match_vertical,parent,false)
      return MatchViewHolder(view)
    }

    override fun getItemCount()= list.size


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentMatch=list[position]
        holder.binding.apply {
                textHomeTeamName.text=currentMatch.homeTeamName
                textAwayTeamName.text=currentMatch.awayTeamName
                textHomeTeamGoals.text=currentMatch.homeTeamGoals.toString()
                textAwayTeamGoals.text=currentMatch.awayTeamGoals.toString()
                textYear.text=currentMatch.year.toString()
            textHomeTeamName.setOnClickListener { listener.onClickTeamName(currentMatch.homeTeamName) }
            textAwayTeamName.setOnClickListener { listener.onClickTeamName(currentMatch.awayTeamName) }
            root.setOnClickListener { listener.onClickItem(currentMatch) }


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

class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding= ItemMatchBinding.bind(itemView)
}
}