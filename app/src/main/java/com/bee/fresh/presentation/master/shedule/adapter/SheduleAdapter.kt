package com.bee.fresh.presentation.master.shedule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R

class SheduleAdapter(val list: List<Pair<String, String>>):
    RecyclerView.Adapter<SheduleAdapter.SheduleViewHolder>() {
    var onItemClick: ((Pair<String, String>) -> Unit)? = null

    inner class SheduleViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val day = itemView.findViewById<TextView>(R.id.day)
        val time = itemView.findViewById<TextView>(R.id.time)
        val sheduleItem = itemView.findViewById<ConstraintLayout>(R.id.sheduleItem)
        fun bind(item: Pair<String, String>) {
            day.text = item.first
            time.text = item.second
            sheduleItem.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SheduleViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.shedule_item, parent, false)
        return SheduleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SheduleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}