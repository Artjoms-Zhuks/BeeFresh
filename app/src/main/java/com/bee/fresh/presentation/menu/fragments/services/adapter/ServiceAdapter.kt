package com.bee.fresh.presentation.menu.fragments.services.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceResponse

class ServiceAdapter(val list: List<ServiceResponse>):
    RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    var onItemClick: ((ServiceResponse) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_item, parent, false)
        return ServiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ServiceViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val serviceName = itemView.findViewById<TextView>(R.id.serviceName)
        val serviceItem = itemView.findViewById<ConstraintLayout>(R.id.serviceItem)
        fun bind(item: ServiceResponse) {
            serviceName.text = item.serviceName
            serviceItem.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}