package com.bee.fresh.presentation.menu.fragments.appointment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceModel

class AppointmentAdapter(val list: List<ServiceModel>):
    RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.appointment_item, parent, false)
        return AppointmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AppointmentViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val serviceName = itemView.findViewById<TextView>(R.id.serviceName)
        val servicePrice = itemView.findViewById<TextView>(R.id.servicePrice)
        fun bind(item: ServiceModel) {
            serviceName.text = item.title
            servicePrice.text = item.cost
        }
    }
}