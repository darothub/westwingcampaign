package com.assessment.data.campaign.repository

import com.assessment.data.campaign.model.*

class FakeCampaignRepository : CampaignRepository {
    private val campaignData = CampaignData(
        true,
        Messages(listOf("SEARCH_QUERY_SUCCESS")),
        Metadata(2, CampaignDetailMockList.list())
    )

    override suspend fun getCampaigns(): List<CampaignDetails> {
        return removeUnWantedCampaign(campaignData)
    }

    override suspend fun removeUnWantedCampaign(campaignData: CampaignData): List<CampaignDetails> {
        return campaignData.metadata.data.filter { !(it.name.isNullOrEmpty() || it.description.isNullOrEmpty()) }
    }
}

