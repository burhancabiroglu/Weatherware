package com.cabir.weatherware.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cabir.weatherware.R
import com.cabir.weatherware.data.entity.Weather

class HourlyWeatherListAdapter constructor(private val reportList:ArrayList<Weather>): RecyclerView.Adapter<HourlyWeatherListAdapter.HourlyWeatherViewHolder>() {


    inner class HourlyWeatherViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(weather: Weather){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.hourly_weather_recycler_item,parent,false)
        return HourlyWeatherViewHolder(view);
    }


    override fun getItemCount(): Int = reportList.size;

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(reportList[position])
    }

}