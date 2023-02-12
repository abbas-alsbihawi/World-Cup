package com.alsbihawi.abbas.worldcup.ui

import android.view.LayoutInflater
import com.alsbihawi.abbas.worldcup.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val LOG_TAG: String
        get() = "SEARCH_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding  = ActivitySearchBinding::inflate
    override fun addCallBacks() {
    }

    override fun setup() {
    }

}