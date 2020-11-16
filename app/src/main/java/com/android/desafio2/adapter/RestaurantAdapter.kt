package com.android.desafio2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.desafio2.R
import com.android.desafio2.model.Restaurant
import com.bumptech.glide.Glide

class RestaurantAdapter(val list: List<Restaurant>,
                        private val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: Restaurant, onItemClicked: (Int) -> Unit) {
            with(itemView) {
                Glide.with(this).load(restaurant.photoUri).into(findViewById<ImageView>(R.id.ivRestaurant))
                findViewById<TextView>(R.id.cdTitle).text = restaurant.name
                findViewById<TextView>(R.id.cdAddress).text = restaurant.address
                findViewById<TextView>(R.id.tvCloseHour).text = restaurant.closeHour.toString()
                setOnClickListener {
                    onItemClicked(this@RestaurantViewHolder.adapterPosition)
                }
            }
        }
    }
}