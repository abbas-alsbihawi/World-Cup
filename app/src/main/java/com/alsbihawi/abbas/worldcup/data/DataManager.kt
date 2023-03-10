package com.alsbihawi.abbas.worldcup.data

import com.alsbihawi.abbas.worldcup.data.domain.Match

object DataManager {
    private val matchesList= mutableListOf<Match>()
     val matches:List<Match>
         get() = matchesList.toList()
    private var indexMatch=0

    fun addMatch(match:Match){
       matchesList.add(match)
    }
    fun addMatchAt(match:Match,index:Int){
        matchesList.add(index,match)
    }

    fun deleteMatchAt(index:Int){
        matchesList.removeAt(index)
    }

    fun getCurrentMatch()= matchesList[indexMatch]

    fun getNextMatch(): Match {
        indexMatch++
        if (indexMatch==matchesList.size) indexMatch= 0
        return matchesList[indexMatch]
    }

    fun getPreviousMatch(): Match {
        indexMatch--
        if (indexMatch==-1) indexMatch= matchesList.size-1
        return matchesList[indexMatch]
    }
}