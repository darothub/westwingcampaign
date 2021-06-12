package com.assessment.data.campaign.model


data class CampaignDetails (
    val name: String,
    val description: String,
    val urlKey: String,
    val image: CampaignImage,
    val view:Int = 1
){
    var id:Long = 0
    companion object {
        var staticId = 0.toLong()
    }
    init {
        id = ++staticId
    }
}