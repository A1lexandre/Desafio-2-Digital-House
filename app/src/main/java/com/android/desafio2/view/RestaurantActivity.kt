
package com.android.desafio2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.desafio2.R
import com.android.desafio2.adapter.MainCourseAdapter
import com.android.desafio2.model.Restaurant
import com.bumptech.glide.Glide

class RestaurantActivity : AppCompatActivity() {

    private val rv: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvMainCourse)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val restaurant = intent.getParcelableExtra<Restaurant>(RestaurantListActivity.RESTAURANT_KEY_NAME)

        restaurant?.let { res ->
            findViewById<ImageView>(R.id.ivRestaurantMainCourse).let {
                Glide.with(this).load(res.photoUri).into(it)
            }

            findViewById<TextView>(R.id.tvRestaurantName).text = res.name

            rv.apply {
                layoutManager = GridLayoutManager(this@RestaurantActivity, 2)
                adapter = MainCourseAdapter(res.mainCourseList) {
                    val intent = Intent(this@RestaurantActivity, MainCourseActivity::class.java)
                    intent.putExtra(MAIN_COURSE_KEY_NAME, res.mainCourseList[it])
                    startActivity(intent)
                }
            }

            findViewById<ImageButton>(R.id.ibBackButton).setOnClickListener {
                finish()
            }

        }


    }

    companion object {
        const val MAIN_COURSE_KEY_NAME = "main_course"
    }

}