package com.assessment.westwingcampaign.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.databinding.ActivityMainBinding
import com.darotpeacedude.core.utils.hideSystemUI
import com.darotpeacedude.core.utils.show
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val campaignListViewModel: CampaignListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        hideSystemUI()

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
                    campaignListViewModel.getCampaignData()
                    binding.mainVf.displayedChild = 0
                    Toast.makeText(this@MainActivity, "true", Toast.LENGTH_SHORT).show()
                } else {
                    binding.mainVf.showNext()
                    Toast.makeText(this@MainActivity, "false", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
