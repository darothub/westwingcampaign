package com.assessment.westwingcampaign.ui.adapters

import android.annotation.SuppressLint
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.aghajari.zoomhelper.ZoomHelper
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.R
import com.assessment.westwingcampaign.databinding.CampaignDetailSingleItemBinding
import com.assessment.westwingcampaign.databinding.CampaignItemLayoutBinding

class CampaignListViewHolder<T : ViewBinding>(private val binding: T) : RecyclerView.ViewHolder(binding.root) {

    var campaignDetails: CampaignDetails? = null

    @SuppressLint("ClickableViewAccessibility")
    fun bindTo(campaignDetails: CampaignDetails?, position: Int, listener: ItemZoomListener) {
        this.campaignDetails = campaignDetails

        binding as CampaignItemLayoutBinding
        binding.campaignNameTv.text = campaignDetails?.name
        binding.campaignImageIv.load(campaignDetails?.image?.url) {
            crossfade(true)
            placeholder(R.drawable.westwing_placeholder)
        }
        ViewCompat.setTransitionName(binding.campaignImageIv, campaignDetails?.name)
        binding.root.setOnClickListener {
            if (campaignDetails != null) {
                listener.navigate(position)
            }
        }

        ZoomHelper.addZoomableView(binding.campaignImageIv)
    }
    fun bindTo(campaignDetails: CampaignDetails?, listener: ItemClickListener) {
        this.campaignDetails = campaignDetails
        binding as CampaignDetailSingleItemBinding
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
