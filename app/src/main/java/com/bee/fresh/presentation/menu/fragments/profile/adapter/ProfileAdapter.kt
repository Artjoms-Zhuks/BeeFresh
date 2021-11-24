package com.bee.fresh.presentation.menu.fragments.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceModel

class ProfileAdapter(val list: List<ServiceModel>):
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_item, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ProfileViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val service = itemView.findViewById<TextView>(R.id.serviceName)
        val cost = itemView.findViewById<TextView>(R.id.cost)
        fun bind(item: ServiceModel) {
            service.text = item.title
            cost.text = item.cost
        }
    }
}
