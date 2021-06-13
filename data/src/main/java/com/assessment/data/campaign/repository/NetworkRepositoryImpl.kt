package com.assessment.data.campaign.repository

import kotlinx.coroutines.flow.StateFlow

class NetworkRepositoryImpl:NetworkRepository {
    override fun getNetworkStatus(): StateFlow<Boolean> {
        TODO("Not yet implemented")
    }
}