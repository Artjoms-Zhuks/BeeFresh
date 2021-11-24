package com.bee.fresh.presentation.master.date.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceModel

class DateAdapter(val list: List<String>):
    RecyclerView.Adapter<DateAdapter.DateViewHolder>() {
    var onClickButton: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.date_item, parent, false)
        return DateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DateViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val dateButton = itemView.findViewById<Button>(R.id.dateButton)
        fun bind(item: String) {
            dateButton.text = item
            dateButton.setOnClickListener {
                onClickButton?.invoke()
            }
        }
    }
}