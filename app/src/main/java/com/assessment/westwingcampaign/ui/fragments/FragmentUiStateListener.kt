package com.assessment.westwingcampaign.ui.fragments

interface FragmentUiStateListener {
    fun <T> onSuccess(data: T)
    fun onError(error: String?)
    fun onNetworkError()
    fun loading()
}
