package com.assessment.data.campaign.repository

import com.assessment.data.campaign.model.CampaignData
import com.assessment.data.campaign.model.CampaignDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface CampaignRepository {
    suspend fun getCampaigns():List<CampaignDetails>
    suspend fun removeUnWantedCampaign(campaignData: CampaignData):List<CampaignDetails>
}