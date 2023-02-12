package com.alsbihawi.abbas.worldcup.ui

import android.view.LayoutInflater
import com.alsbihawi.abbas.worldcup.data.DataManager
import com.alsbihawi.abbas.worldcup.data.domain.Match
import com.alsbihawi.abbas.worldcup.databinding.ActivityMainBinding
import com.alsbihawi.abbas.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity:BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String ="MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding=ActivityMainBinding::inflate

    override fun addCallBacks() {
       val currentMatch= DataManager.getCurrentMatch()
        binding?.apply {
            iconNext.setOnClickListener {
                bindMatch(DataManager.getNextMatch())
            }
            iconPrevious.setOnClickListener {
                bindMatch(DataManager.getPreviousMatch())
            }
        }
    }

    override fun setup() {
        parseFile()
    }

    private fun  parseFile(){
        val inputStream=   assets.open("worldcup.csv")
        val buffer=BufferedReader(InputStreamReader(inputStream))
        val parser=CsvParser()
        buffer.forEachLine {
            log(it)
           val currentMatch= parser.parser(it)
            DataManager.addMatch(currentMatch)
            bindMatch(DataManager.getCurrentMatch())
        }
    }

    private fun bindMatch(match: Match){
        binding?.apply {
            textYear.text=match.year.toString()
            textHomeTeamName.text=match.homeTeamName
            textAwayTeamName.text=match.awayTeamName
            textHomeTeamGoals.text=match.homeTeamGoals.toString()
            textAwayTeamGoals.text=match.awayTeamGoals.toString()
            textStadium.text=match.stadium
        }
    }
}