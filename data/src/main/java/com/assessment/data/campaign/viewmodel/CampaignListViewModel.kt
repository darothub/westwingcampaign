package com.assessment.data.campaign.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.repository.CampaignRepository
import com.assessment.data.campaign.repository.NetworkRepository
import com.assessment.data.campaign.state.CampaignUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class CampaignListViewModel @Inject constructor(
    private val repositoryImpl: CampaignRepository,
    private val networkRepositoryImpl: NetworkRepository?
) : ViewModel() {
    private val TAG by lazy { this::class.qualifiedName!! }
    private val _campaignUiState = MutableStateFlow<CampaignUiState>(CampaignUiState.Nothing)
    val campaignUiState:StateFlow<CampaignUiState> get() = _campaignUiState
    var adapterPosition = 0


    init {
        viewModelScope.launch {
            networkRepositoryImpl?.getNetworkStatus()
                ?.collect {
                    if (!it) {
                        _campaignUiState.value = CampaignUiState.NetworkError
                    }
                }
        }
    }


    suspend fun getCampaignDetails() {
        _campaignUiState.value = CampaignUiState.Loading
        try {
            val campaigns = repositoryImpl.getCampaigns()
            _campaignUiState.value = CampaignUiState.Success(campaigns)
        }
        catch (e:Throwable){
            if (e is UnknownHostException){
                _campaignUiState.value = CampaignUiState.NetworkError
            }
            else{
                _campaignUiState.value = CampaignUiState.Error(e)
            }

        }
    }

    @VisibleForTesting
    internal suspend fun getCampaignDetailsForTest() = repositoryImpl.getCampaigns()



}
