package com.alsbihawi.abbas.worldcup.ui

import androidx.recyclerview.widget.DiffUtil
import com.alsbihawi.abbas.worldcup.data.domain.Match

class MatchDiffUtil(val mOldList: List<Match>,val mNewList: List<Match>,):DiffUtil.Callback() {
    override fun getOldListSize()=mOldList.size

    override fun getNewListSize()=mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  (
                mOldList[oldItemPosition].homeTeamName==mNewList[newItemPosition].homeTeamName
                        &&mOldList[oldItemPosition].awayTeamName==mNewList[newItemPosition].awayTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  true
    }
}