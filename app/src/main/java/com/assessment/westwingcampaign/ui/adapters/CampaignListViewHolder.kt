package com.assessment.westwingcampaign.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.CampaignItemLayoutBinding

class CampaignListViewHolder(private val binding: CampaignItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    var campaignDetails: CampaignDetails? = null

    fun bindTo(campaignDetails: CampaignDetails?, position: Int, listener: ItemZoomListener) {
        this.campaignDetails = campaignDetails
        binding.campaignNameTv.text = campaignDetails?.name
        binding.campaignImageIv.load(campaignDetails?.image?.url) {
            crossfade(true)
            placeholder(R.drawable.westwing_placeholder)
        }
        binding.root.setOnClickListener {
            if (campaignDetails != null) {
                listener.navigate(position)
            }
        }
        binding.campaignImageIv.setOnScaleChangeListener { _, _, _ ->
            if (campaignDetails != null) {
                listener.navigate(position)
            }
        }
        binding.campaignImageIv.setOnDoubleTapListener(null)
    }
}
