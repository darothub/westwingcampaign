package com.assessment.data.campaign.repository

import com.assessment.data.campaign.model.CampaignData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface CampaignRepository {
    suspend fun getCampaigns():CampaignData
}