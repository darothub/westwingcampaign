package com.assessment.westwingcampaign.ui.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.FragmentLandingBinding
import com.assessment.westwingcampaign.ui.adapters.CampaignListViewAdapter
import com.assessment.westwingcampaign.ui.adapters.ItemSpaceDecoration
import com.assessment.westwingcampaign.ui.adapters.ItemZoomListener
import com.assessment.westwingcampaign.utils.checkOrientation
import com.darotpeacedude.core.utils.getName
import com.darotpeacedude.core.utils.goto
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * A simple [Fragment] subclass.
 * Use the [LandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.fragment_landing), ItemZoomListener {
    private val TAG by lazy { getName() }
    private val binding by viewBinding(FragmentLandingBinding::bind)
    private val campaignListViewModel: CampaignListViewModel by activityViewModels()
    lateinit var campaignViewAdapter: CampaignListViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        campaignViewAdapter = CampaignListViewAdapter(this)
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
        val orientation = checkOrientation()
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.campaignListErcv.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = campaignViewAdapter
                addItemDecoration(ItemSpaceDecoration(8, 2))
            }
        } else {
            binding.campaignListErcv.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = campaignViewAdapter
                addItemDecoration(ItemSpaceDecoration(8, 1))
            }
        }
    }

    override fun navigate(position: Int) {
        val direction = LandingFragmentDirections.actionLandingFragmentToCampaignDetailsFragment(position)
        goto(direction)
    }
}
