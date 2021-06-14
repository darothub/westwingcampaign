package com.assessment.westwingcampaign.ui.activities

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aghajari.zoomhelper.ZoomHelper
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.databinding.ActivityMainBinding
import com.assessment.westwingcampaign.utils.extensions.hide
import com.assessment.westwingcampaign.utils.extensions.show
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityUiStateListener {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val campaignListViewModel: CampaignListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        getCampaignData()
        binding.networkLayout.retryBtn.setOnClickListener {
            getCampaignData()
        }
    }

    private fun getCampaignData() {
        lifecycleScope.launchWhenStarted {
            campaignListViewModel.getCampaignDetails()
        }
    }

    override fun showErrorPage(error: String?) {
        binding.mainVf.displayedChild = 1
        error?.let {
            binding.networkLayout.networkErrorMessageTv.text = it
        }
        binding.networkLayout.progressbar.hide()
        binding.networkLayout.retryBtn.show()
    }

    override fun loading() {
        binding.networkLayout.progressbar.show()
        binding.networkLayout.retryBtn.hide()
    }

    override fun displayDataFragment() {
        binding.mainVf.displayedChild = 0
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return ZoomHelper.getInstance().dispatchTouchEvent(ev!!, this) || super.dispatchTouchEvent(ev)
    }
}
