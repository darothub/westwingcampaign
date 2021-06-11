package com.assessment.data.campaign.services

import com.assessment.data.campaign.model.CampaignData
import retrofit2.http.GET


interface RemoteService {
    @GET("campaigns.json")
    suspend fun getCampaigns():CampaignData
}