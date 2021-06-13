package com.assessment.data.campaign.state

import com.assessment.data.campaign.model.CampaignDetails

sealed class CampaignUiState {
    data class Success<T>(val data: T): CampaignUiState()
    data class Error(val exception: Throwable): CampaignUiState()
    object NetworkError : CampaignUiState()
    object Loading : CampaignUiState()
    object Nothing : CampaignUiState()
}
