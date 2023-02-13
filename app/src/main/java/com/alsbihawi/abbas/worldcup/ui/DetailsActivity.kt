package com.alsbihawi.abbas.worldcup.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.alsbihawi.abbas.worldcup.data.domain.Match
import com.alsbihawi.abbas.worldcup.databinding.ActivityDetailsBinding
import com.alsbihawi.abbas.worldcup.util.Constants

class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {
    override val LOG_TAG: String ="DETAILS_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityDetailsBinding = ActivityDetailsBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      val currentMatch:Match= intent.getSerializableExtra(Constants.MATCH) as Match

        binding?.apply {
            textHomeTeamName.text=currentMatch.homeTeamName
            textAwayTeamName.text=currentMatch.awayTeamName
            textHomeTeamGoals.text=currentMatch.homeTeamGoals.toString()
            textAwayTeamGoals.text=currentMatch.awayTeamGoals.toString()
            textYear.text=currentMatch.year.toString()
        }
    }
    override fun addCallBacks() {

    }

    override fun setup() {

    }

}