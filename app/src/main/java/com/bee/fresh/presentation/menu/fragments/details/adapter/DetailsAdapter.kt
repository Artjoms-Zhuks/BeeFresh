package com.bee.fresh.presentation.menu.fragments.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.ServiceResponse

class DetailsAdapter(val list: List<String>):
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    var onItemClick: ((String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.details_item, parent, false)
        return DetailsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DetailsViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.detailsTitle)
        val chooseDetail = itemView.findViewById<ImageView>(R.id.chooseCategory)
        fun bind(item: String) {
            title.text = item
            chooseDetail.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}
