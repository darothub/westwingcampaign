package com.assessment.data.campaign.model

import java.io.Serializable


data class CampaignDetails(
    val name: String?,
    val description: String,
    val urlKey: String,
    val image: CampaignImage,
    val view:Int = 1
):Serializable