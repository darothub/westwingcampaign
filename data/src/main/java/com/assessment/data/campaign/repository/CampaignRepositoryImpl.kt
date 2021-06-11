package com.assessment.data.campaign.repository

import android.util.Log
import com.assessment.data.campaign.model.CampaignData
import com.assessment.data.campaign.services.RemoteService
import javax.inject.Inject

class CampaignRepositoryImpl @Inject constructor(private val remoteService: RemoteService):CampaignRepository  {
    override suspend fun getCampaigns():CampaignData {
        Log.i("Repository", "${remoteService.getCampaigns()}")
        return remoteService.getCampaigns()
    }
}