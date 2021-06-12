package com.assessment.westwingcampaign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.westwingcampaign.databinding.CampaignDetailSingleItemBinding

class CampaignSingleViewAdapter(var listener: ItemClickListener) : RecyclerView.Adapter<CampaignSingleViewHolder>() {
    var list = ArrayList<CampaignDetails>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignSingleViewHolder {
        val binding = CampaignDetailSingleItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignSingleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampaignSingleViewHolder, position: Int) {
        val item = list[position]
        holder.bindTo(item, listener)
    }
    override fun getItemCount(): Int = list.size
    fun setData(newList: List<CampaignDetails>) {
        val withName = newList.filter { !(it.name.isNullOrEmpty() || it.description.isNullOrEmpty()) }
        list.addAll(withName)
        notifyDataSetChanged()
    }
}
interface ItemClickListener {
    fun navigate()
}
