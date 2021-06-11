package com.assessment.westwingcampaign.ui.fragments

import androidx.fragment.app.Fragment
import com.assessment.westwingcampaign.databinding.FragmentCampaignDetailsBinding
import com.darotpeacedude.core.utils.getName
import com.darotpeacedude.eivom.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [CampaignDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CampaignDetailsFragment : Fragment() {
    private val TAG by lazy { getName() }
    private val binding by viewBinding(FragmentCampaignDetailsBinding::bind)
}
