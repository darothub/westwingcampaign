package com.assessment.data.campaign.repository

import com.assessment.data.campaign.model.CampaignData

interface CampaignRepository {
    suspend fun getCampaigns():CampaignData
}