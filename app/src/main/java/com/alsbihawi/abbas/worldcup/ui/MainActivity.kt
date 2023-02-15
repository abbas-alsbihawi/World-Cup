package com.alsbihawi.abbas.worldcup.ui

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.alsbihawi.abbas.worldcup.data.DataManager
import com.alsbihawi.abbas.worldcup.data.domain.Match
import com.alsbihawi.abbas.worldcup.databinding.ActivityMainBinding
import com.alsbihawi.abbas.worldcup.util.Constants
import com.alsbihawi.abbas.worldcup.util.CsvParser

import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity:BaseActivity<ActivityMainBinding>(),MatchInteractionListener {

    override val LOG_TAG: String ="MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding=ActivityMainBinding::inflate

    lateinit var adapter: MatchAdapter
    override fun addCallBacks() {
        binding?.fab?.setOnClickListener {
            addMatch()
        }
    }

    private fun addMatch() {
        val finalMatch=Match(
            year= 2018,
            stadium= "stadium",
            city= "moscow",
            homeTeamName= "France",
            awayTeamName= "Croatia",
            homeTeamGoals= 4,
            awayTeamGoals= 2,
            refereeName= "",
        )
        DataManager.addMatch(finalMatch)
        adapter.setList(DataManager.matches)
    }

    override fun setup() {
        parseFile()
           adapter=MatchAdapter(DataManager.matches,this)
        binding?.apply {
            recyclerMatch.adapter= adapter
        }

    }

    private fun  parseFile(){
        val inputStream=   assets.open("worldcup.csv")
        val buffer=BufferedReader(InputStreamReader(inputStream))
        val parser=CsvParser()
        buffer.forEachLine {
            log(it)
           val currentMatch= parser.parser(it)
            DataManager.addMatch(currentMatch)
//            bindMatch(DataManager.getCurrentMatch())
        }
    }

    override fun onClickItem(match: Match) {
       val intent=Intent(this,DetailsActivity::class.java)
        intent.putExtra(Constants.MATCH,match)
        startActivity(intent)
    }

    override fun onClickTeamName(name: String) {
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
    }

//    private fun bindMatch(match: Match){
//        binding?.apply {
//            textYear.text=match.year.toString()
//            textHomeTeamName.text=match.homeTeamName
//            textAwayTeamName.text=match.awayTeamName
//            textHomeTeamGoals.text=match.homeTeamGoals.toString()
//            textAwayTeamGoals.text=match.awayTeamGoals.toString()
//            textStadium.text=match.stadium
//        }
//    }
}