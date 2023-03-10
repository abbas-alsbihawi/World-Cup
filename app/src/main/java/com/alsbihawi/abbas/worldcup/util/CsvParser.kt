package com.alsbihawi.abbas.worldcup.util

import com.alsbihawi.abbas.worldcup.data.domain.Match

class CsvParser {
    fun parser(line:String):Match{
        val tokens=line.split(",")
        return Match(
            year = tokens[Constants.ColumnIndex.YEAR].toInt(),
            stadium = tokens[Constants.ColumnIndex.STADIUM],
            city = tokens[Constants.ColumnIndex.CITY],
            homeTeamName = tokens[Constants.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constants.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals = tokens[Constants.ColumnIndex.HOME_TEAM_GOALS].toInt(),
            awayTeamGoals = tokens[Constants.ColumnIndex.AWAY_TEAM_GOALS].toInt(),
            refereeName = tokens[Constants.ColumnIndex.REFEREE_NAME],
        )
    }
}