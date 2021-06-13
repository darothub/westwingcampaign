package com.assessment.data.campaign.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface NetworkRepository {
    fun getNetworkStatus(): StateFlow<Boolean>
}