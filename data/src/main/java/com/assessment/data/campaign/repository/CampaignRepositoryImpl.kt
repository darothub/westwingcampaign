package com.assessment.data.campaign.repository

import android.util.Log
import com.assessment.data.campaign.model.CampaignData
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.services.RemoteService
import javax.inject.Inject

class CampaignRepositoryImpl @Inject constructor(private val remoteService: RemoteService):CampaignRepository  {
    override suspend fun getCampaigns():List<CampaignDetails> {
        return removeUnWantedCampaign(remoteService.getCampaigns())
    }

    override suspend fun removeUnWantedCampaign(campaignData: CampaignData): List<CampaignDetails> {
        return campaignData.metadata.data.filter { !(it.name.isNullOrEmpty() || it.description.isNullOrEmpty()) }
    }
}