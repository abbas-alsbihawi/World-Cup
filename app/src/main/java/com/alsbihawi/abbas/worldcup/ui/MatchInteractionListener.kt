package com.alsbihawi.abbas.worldcup.ui

import com.alsbihawi.abbas.worldcup.data.domain.Match

interface MatchInteractionListener {
    fun onClickItem(match: Match)
    fun onClickTeamName(name: String)
    fun deleteAtItem(index: Int)
}