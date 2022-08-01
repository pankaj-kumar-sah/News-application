package com.example.newsapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.data.HealthyData

class HealthyAdapter(var context: Context?) : RecyclerView.Adapter<HealthyAdapter.ViewHolder>() {

    var healthyList = emptyList<HealthyData>()

    internal fun setHealthyList(healthyList: List<HealthyData>){
        this.healthyList = healthyList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var healthyImage : ImageView
        init {
            healthyImage = itemView.findViewById(R.id.healthyRecyclerImage)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthyAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.healthy_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HealthyAdapter.ViewHolder, position: Int) {
        var data = healthyList[position]

        holder.healthyImage.setImageResource(data.healthyImage)
    }

    override fun getItemCount(): Int {
        return healthyList.size
    }

}