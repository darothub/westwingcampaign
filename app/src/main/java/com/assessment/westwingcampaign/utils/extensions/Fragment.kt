package com.assessment.westwingcampaign.utils.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.assessment.data.campaign.state.CampaignUiState
import com.assessment.westwingcampaign.ui.fragments.FragmentUiStateListener
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

/**
 * Navigate to destination id
 *
 * @param destinationId
 */
fun Fragment.goto(destinationId: Int) {
    findNavController().navigate(destinationId)
}

/**
 * Navigate to destination id
 *
 * @param direction
 */
fun Fragment.goto(direction: NavDirections) {
    Navigation.findNavController(requireView()).navigate(direction)
}

/**
 * Navigate up
 *
 */
fun Fragment.gotoUp() {
    Navigation.findNavController(requireView()).navigateUp()
}

fun Fragment.setUpUiState(uiStateFlow: StateFlow<CampaignUiState>, fragmentUiUpdate: FragmentUiStateListener) {
    lifecycleScope.launchWhenStarted {
        uiStateFlow.collectLatest { state ->
            when (state) {
                is CampaignUiState.Success<*> -> {
                    fragmentUiUpdate.onSuccess(state.data)
                }
                is CampaignUiState.NetworkError -> {
                    fragmentUiUpdate.onError(null)
                }
                is CampaignUiState.Error -> {
                    fragmentUiUpdate.onError(state.exception.message)
                }
                is CampaignUiState.Loading -> {
                    fragmentUiUpdate.loading()
                }
                is CampaignUiState.Nothing -> {
                    fragmentUiUpdate.onError(null)
                }
            }
        }
    }
}
