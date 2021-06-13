package com.assessment.westwingcampaign

import androidx.appcompat.app.AppCompatActivity
import com.assessment.westwingcampaign.ui.activities.ActivityUiStateListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity(), ActivityUiStateListener {
    override fun showErrorPage(error: String?) {}

    override fun loading() {}

    override fun displayDataFragment() {}
}
