package com.bee.fresh.presentation.menu.fragments.choose.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceModel

class ChooseAdapter(val list: List<ServiceModel>):
    RecyclerView.Adapter<ChooseAdapter.ChooseViewHolder>() {
    var chooseListener: ((ServiceModel, Boolean) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.choose_item, parent, false)
        return ChooseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ChooseViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val serviceName = itemView.findViewById<TextView>(R.id.serviceName)
        val servicePrice = itemView.findViewById<TextView>(R.id.servicePrice)
        val setService = itemView.findViewById<RadioButton>(R.id.setService)
        fun bind(item: ServiceModel) {
            serviceName.text = item.title
            servicePrice.text = item.cost
            setService.setOnCheckedChangeListener { compoundButton, b ->
                when (b) {
                    false -> {
                        chooseListener?.invoke(item, false)
                    }
                    true -> {
                        chooseListener?.invoke(item, true)
                    }
                }
            }
        }
    }
}