package com.android.desafio2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.desafio2.R
import com.android.desafio2.model.MainCourse
import com.bumptech.glide.Glide

class MainCourseAdapter(private val list: List<MainCourse>,
                        private val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<MainCourseAdapter.MainCourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCourseViewHolder {
        return MainCourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_course_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainCourseViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    inner class MainCourseViewHolder(itemVew: View) : RecyclerView.ViewHolder(itemVew) {
        fun bind(mainCourse: MainCourse, onItemClicked: (Int) -> Unit) {
            with(itemView) {
                Glide.with(this).load(mainCourse.photoUri).into(findViewById(R.id.ivMainCourse))
                findViewById<TextView>(R.id.tvMainCourseName).text = mainCourse.name

                setOnClickListener{
                    onItemClicked(this@MainCourseViewHolder.adapterPosition)
                }
            }
        }
    }
}