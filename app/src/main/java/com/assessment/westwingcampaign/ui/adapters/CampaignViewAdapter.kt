package com.assessment.westwingcampaign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.databinding.CampaignItemLayoutBinding

class CampaignViewAdapter(var listener: (CampaignDetails) -> Unit) : RecyclerView.Adapter<CampaignListViewHolder>() {
    var list = ArrayList<CampaignDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignListViewHolder {
        val binding = CampaignItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampaignListViewHolder, position: Int) {
        val item = list[position]
        holder.bindTo(item, listener)
    }
    override fun getItemCount(): Int = list.size
    fun setData(newList: List<CampaignDetails>) {
        val withName = newList.filter { !it.name.isNullOrEmpty() }
        list.addAll(withName)
        notifyDataSetChanged()
    }
}
