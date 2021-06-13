package com.assessment.core.state

sealed class CampaignUiState {
    data class Success<T>(val data: List<T>): CampaignUiState()
    data class Error(val exception: Throwable): CampaignUiState()
    object NetworkError :CampaignUiState()
}
