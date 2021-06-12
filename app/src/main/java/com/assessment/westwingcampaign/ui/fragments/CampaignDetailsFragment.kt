package com.assessment.westwingcampaign.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.FragmentCampaignDetailsBinding
import com.assessment.westwingcampaign.ui.adapters.CampaignSingleViewAdapter
import com.assessment.westwingcampaign.ui.adapters.ItemClickListener
import com.darotpeacedude.core.utils.getName
import com.darotpeacedude.core.utils.gotoUp
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * A simple [Fragment] subclass.
 * Use the [CampaignDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CampaignDetailsFragment : Fragment(R.layout.fragment_campaign_details), ItemClickListener {
    private val TAG by lazy { getName() }
    private val binding by viewBinding(FragmentCampaignDetailsBinding::bind)
    private val campaignListViewModel: CampaignListViewModel by activityViewModels()
    lateinit var campaignViewAdapter: CampaignSingleViewAdapter
    private val arg by navArgs<CampaignDetailsFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        campaignViewAdapter = CampaignSingleViewAdapter(this)
    }
    override fun onResume() {
        super.onResume()
        setUpData()
        binding.campaignDetailsVp2.adapter = campaignViewAdapter
        binding.campaignDetailsVp2.post {
            binding.campaignDetailsVp2.setCurrentItem(arg.position, false)
        }
    }

    private fun setUpData() {
        lifecycleScope.launchWhenStarted {
            campaignListViewModel.campaignStateFlow.collectLatest {
                campaignViewAdapter.setData(it)
            }
        }
    }

    override fun navigate() {
        gotoUp()
    }
}
