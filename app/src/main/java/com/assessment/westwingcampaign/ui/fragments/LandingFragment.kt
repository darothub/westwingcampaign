package com.assessment.westwingcampaign.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.FragmentLandingBinding
import com.assessment.westwingcampaign.ui.adapters.CampaignViewAdapter
import com.darotpeacedude.core.utils.getName
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * A simple [Fragment] subclass.
 * Use the [LandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.fragment_landing) {
    private val TAG by lazy { getName() }
    private val binding by viewBinding(FragmentLandingBinding::bind)
    private val campaignListViewModel: CampaignListViewModel by viewModels()
    lateinit var campaignViewAdapter: CampaignViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            campaignListViewModel.getCampaignData()
        }
        campaignViewAdapter = CampaignViewAdapter {
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        setupView()
        setUpData()
    }

    private fun setUpData() {
        lifecycleScope.launchWhenStarted {
            campaignListViewModel.campaignStateFlow.collectLatest {
                Log.i(TAG, it.toString())
                campaignViewAdapter.setData(it)
            }
        }
    }

    private fun setupView() {
        binding.campaignListErcv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = campaignViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
