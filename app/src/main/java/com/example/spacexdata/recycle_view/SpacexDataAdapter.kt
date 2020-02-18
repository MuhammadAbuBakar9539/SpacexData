package com.example.spacexdata.recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexdata.R
import com.example.spacexdata.model.SpacexDataResponse
import kotlinx.android.synthetic.main.data_item.view.*

class SpacexDataAdapter(private val spacexDataResponseList: List<SpacexDataResponse>):RecyclerView.Adapter<SpacexDataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false))
    }

    override fun getItemCount(): Int {
        return spacexDataResponseList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.name.text = spacexDataResponseList[position].rocketName
        holder.country.text = spacexDataResponseList[position].country
        holder.engin_count.text = spacexDataResponseList[position].firstStage.engines.toString()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.tv_name_data
        val country:TextView = itemView.tv_country_data
        val engin_count:TextView = itemView.tv_engine_count_data
    }

}