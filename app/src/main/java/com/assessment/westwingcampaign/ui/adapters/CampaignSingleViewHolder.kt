package com.assessment.westwingcampaign.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.CampaignDetailSingleItemBinding

class CampaignSingleViewHolder(private val binding: CampaignDetailSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {

    var campaignDetails: CampaignDetails? = null

    fun bindTo(campaignDetails: CampaignDetails?, listener: ItemClickListener) {
        this.campaignDetails = campaignDetails

        binding.bs.descriptionTv.text = campaignDetails?.description
        binding.bs.nameTv.text = campaignDetails?.name
        binding.blurBgIv.load(campaignDetails?.image?.url) {
            crossfade(true)
            placeholder(R.drawable.westwing_placeholder)
        }
        binding.backbtnIv.setOnClickListener {
            if (campaignDetails != null) {
                listener.navigate()
            }
        }
        binding.bs.callBtn.setOnClickListener {
            listener.callNow()
        }
    }
}
