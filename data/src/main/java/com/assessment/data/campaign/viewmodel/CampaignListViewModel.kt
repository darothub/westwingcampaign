package com.assessment.data.campaign.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.repository.CampaignRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CampaignListViewModel @Inject constructor(
    private val repositoryImpl: CampaignRepository,
    @ApplicationContext val appContext: Context
) : ViewModel() {
    private val TAG by lazy { this::class.qualifiedName!! }
    private val _netWorkStateFlow = MutableStateFlow(false)
    val netWorkStateFlow get() = _netWorkStateFlow
    val _campaignStateFlow = MutableStateFlow(emptyList<CampaignDetails>())
    val campaignStateFlow get() = _campaignStateFlow

//    init {
//        networkMonitor()
//    }

    suspend fun getCampaignData() {
        Log.i(TAG, "${repositoryImpl.getCampaigns().metadata.data}")
        _campaignStateFlow.value = repositoryImpl.getCampaigns().metadata.data
    }



    @Synchronized
    private fun networkMonitor() {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                _netWorkStateFlow.value = true
            }

            override fun onLost(network: Network) {
                _netWorkStateFlow.value = false
            }
        }

        val connectivityManager =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.let {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                it.registerDefaultNetworkCallback(networkCallback)
            } else {
                val request: NetworkRequest = NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
                it.registerNetworkCallback(request, networkCallback)
            }
        }
    }

}
