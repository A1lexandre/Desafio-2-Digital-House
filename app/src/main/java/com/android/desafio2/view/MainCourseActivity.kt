package com.android.desafio2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.android.desafio2.R
import com.android.desafio2.model.MainCourse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main_course.*

class MainCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_course)

        val mainCourse = intent.getParcelableExtra<MainCourse>(RestaurantActivity.MAIN_COURSE_KEY_NAME)

        mainCourse?.let { main ->
            findViewById<ImageView>(R.id.ivMainCourseDetail).let {
                Glide.with(this).load(main.photoUri).into(it)
            }

            findViewById<TextView>(R.id.tvMainCourseName).text = main.name
            findViewById<TextView>(R.id.tvMainCourseDescription).text = main.description
        }

        ibBackButton.setOnClickListener {
            finish()
        }
    }
}