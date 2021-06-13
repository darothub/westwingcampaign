package com.assessment.westwingcampaign.ui.activities

interface ActivityUiStateListener {
    fun showErrorPage(error: String?)
    fun loading()
    fun displayDataFragment()
}
