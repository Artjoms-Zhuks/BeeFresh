package com.bee.fresh.presentation.menu.fragments.masters.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.domain.model.ServiceResponse
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MastersAdapter(val list: List<MasterUiModel>, val context: Context) :
    RecyclerView.Adapter<MastersAdapter.MastersViewHolder>() {
    var onItemClick: ((MasterUiModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MastersViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.masters_item, parent, false)
        return MastersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MastersViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MastersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val masterName = itemView.findViewById<TextView>(R.id.masterName)
        val adress = itemView.findViewById<TextView>(R.id.adress)
        val masterProfile = itemView.findViewById<Button>(R.id.masterDescription)
        val profileIcon = itemView.findViewById<ImageView>(R.id.profileImage)
        fun bind(item: MasterUiModel) {
            //      Picasso.with(context)
            //      .load("https://beefresh.000webhostapp.com/images/image2.jpg")
            //         .into(profileIcon)
            masterName.text = item.name
            adress.text = item.adress
            masterProfile.setOnClickListener {
                onItemClick?.invoke(item)
            }
            when (item.pictureCount) {
                1 -> {
                    profileIcon.setImageResource(R.drawable.image1)
                }
                2 -> {
                    profileIcon.setImageResource(R.drawable.image2)
                }
                3 -> {
                    profileIcon.setImageResource(R.drawable.image3)
                }
                4 -> {
                    profileIcon.setImageResource(R.drawable.image4)
                }
                5 -> {
                    profileIcon.setImageResource(R.drawable.image5)
                }
                6 -> {
                    profileIcon.setImageResource(R.drawable.image6)
                }
                7 -> {
                    profileIcon.setImageResource(R.drawable.image7)
                }
                8 -> {
                    profileIcon.setImageResource(R.drawable.image8)
                }
                9 -> {
                    profileIcon.setImageResource(R.drawable.image9)
                }
                10 -> {
                    profileIcon.setImageResource(R.drawable.image10)
                }
                11 -> {
                    profileIcon.setImageResource(R.drawable.image11)
                }
                12 -> {
                    profileIcon.setImageResource(R.drawable.image12)
                }
            }
           /* Picasso.with(adress.context)
                .load()
                .placeholder
                .error(R.drawable.user_placeholder_error)
                .into(ImageView);*/
        }
    }
}