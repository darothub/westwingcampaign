package com.assessment.westwingcampaign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.databinding.CampaignItemLayoutBinding

class CampaignListViewAdapter(var listener: ItemZoomListener) : RecyclerView.Adapter<CampaignListViewHolder<CampaignItemLayoutBinding>>() {
    var list = ArrayList<CampaignDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignListViewHolder<CampaignItemLayoutBinding> {
        val binding = CampaignItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampaignListViewHolder<CampaignItemLayoutBinding>, position: Int) {
        val item = list[position]
        holder.bindTo(item, position, listener)
        holder.setIsRecyclable(false)
    }
    override fun getItemCount(): Int = list.size
    fun setData(newList: List<CampaignDetails>?) {
        if (newList != null) {
            list.addAll(newList)
        }
        notifyDataSetChanged()
    }
}
