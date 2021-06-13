package com.assessment.westwingcampaign.ui.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.araujo.jordan.excuseme.ExcuseMe
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.viewmodel.CampaignListViewModel
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.FragmentCampaignDetailsBinding
import com.assessment.westwingcampaign.ui.activities.ActivityUiStateListener
import com.assessment.westwingcampaign.ui.adapters.CampaignSingleViewAdapter
import com.assessment.westwingcampaign.ui.adapters.ItemClickListener
import com.assessment.westwingcampaign.utils.extensions.getName
import com.assessment.westwingcampaign.utils.extensions.gotoUp
import com.assessment.westwingcampaign.utils.extensions.setUpUiState
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [CampaignDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CampaignDetailsFragment : Fragment(R.layout.fragment_campaign_details), ItemClickListener, FragmentUiStateListener {
    private val TAG by lazy { getName() }
    private val binding by viewBinding(FragmentCampaignDetailsBinding::bind)
    private val campaignListViewModel: CampaignListViewModel by activityViewModels()
    lateinit var campaignViewAdapter: CampaignSingleViewAdapter
    lateinit var activityUiState: ActivityUiStateListener
    lateinit var fragmentUiStateListener: FragmentUiStateListener
    private val arg by navArgs<CampaignDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        fragmentUiStateListener = this
        campaignViewAdapter = CampaignSingleViewAdapter(this)
    }
    override fun onResume() {
        super.onResume()
        setUpData()
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.campaignDetailsVp2.adapter = campaignViewAdapter
        binding.campaignDetailsVp2.post {
            binding.campaignDetailsVp2.setCurrentItem(arg.position, false)
        }
    }

    private fun setUpData() {
        setUpUiState(campaignListViewModel.campaignUiState, fragmentUiStateListener)
    }

    override fun navigate() {
        gotoUp()
    }

    override fun callNow() {
        val bool = ExcuseMe.doWeHavePermissionFor(requireContext(), Manifest.permission.CALL_PHONE)
        if (!bool) {
            checkPermission()
        } else {
            callSupport()
        }
    }

    private fun checkPermission() {
        ExcuseMe.couldYouGive(this).permissionFor(
            Manifest.permission.CALL_PHONE,
        ) {
            if (it.granted.contains(Manifest.permission.CALL_PHONE)) {
                callSupport()
            } else {
                lifecycleScope.launch {
                    ExcuseMe.couldYouGive(requireActivity()).gently(
                        "Permission Request",
                        "To easily contact westwing support, grant the app call permission"
                    ).permissionFor(Manifest.permission.CALL_PHONE)
                }
            }
        }
    }

    private fun callSupport() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:+498941207272")
        startActivity(callIntent)
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun <T> onSuccess(data: T) {
        campaignViewAdapter.setData(data as? List<CampaignDetails>)
        activityUiState.displayDataFragment()
    }

    override fun onError(error: String?) {
        activityUiState.showErrorPage(error)
    }

    override fun onNetworkError() {
        activityUiState.showErrorPage(null)
    }

    override fun loading() {
        activityUiState.loading()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityUiState = requireActivity() as ActivityUiStateListener
    }
}
