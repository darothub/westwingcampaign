package com.assessment.westwingcampaign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.databinding.CampaignDetailSingleItemBinding

class CampaignSingleViewAdapter(var listener: ItemClickListener) : RecyclerView.Adapter<CampaignListViewHolder<CampaignDetailSingleItemBinding>>() {
    var list = ArrayList<CampaignDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignListViewHolder<CampaignDetailSingleItemBinding> {
        val binding = CampaignDetailSingleItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampaignListViewHolder<CampaignDetailSingleItemBinding>, position: Int) {
        val item = list[position]
        holder.bindTo(item, listener)
    }
    override fun getItemCount(): Int = list.size
    fun setData(newList: List<CampaignDetails>?) {
        val withName = newList?.filter { !(it.name.isNullOrEmpty() || it.description.isNullOrEmpty()) }
        if (withName != null) {
            list.addAll(withName)
        }
        notifyDataSetChanged()
    }
}
