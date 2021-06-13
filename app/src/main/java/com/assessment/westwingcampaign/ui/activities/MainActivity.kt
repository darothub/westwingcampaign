package com.assessment.westwingcampaign.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.databinding.ActivityMainBinding
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val campaignListViewModel: CampaignListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        binding.networkLayout.retryBtn.setOnClickListener {
            campaignListViewModel.networkMonitor()
        }
    }

    override fun onResume() {
        super.onResume()
        checkNetworkAndReceiveData()
    }

    private fun checkNetworkAndReceiveData() {
        lifecycleScope.launchWhenCreated {
            campaignListViewModel.netWorkStateFlow.collectLatest {
                if (it) {
                    try {
                        campaignListViewModel.getCampaignData()
                    } catch (e: Exception) {
                        if ((e !is UnknownHostException)) binding.networkLayout.networkErrorMessageIv.text =
                            e.message
                        binding.mainVf.displayedChild = 1
                    }
                    binding.mainVf.displayedChild = 0
                } else {
                    binding.mainVf.displayedChild = 1
                }
            }
        }
    }
}
