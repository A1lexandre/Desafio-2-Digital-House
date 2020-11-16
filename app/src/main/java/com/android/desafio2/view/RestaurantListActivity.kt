package com.android.desafio2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.desafio2.R
import com.android.desafio2.adapter.RestaurantAdapter
import com.android.desafio2.model.MainCourse
import com.android.desafio2.model.Restaurant
import com.mooveit.library.Fakeit


class RestaurantListActivity : AppCompatActivity() {

    private val rv: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvRestaurant)
    }

    lateinit var restaurantList: List<Restaurant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        Fakeit.init()

        restaurantList = createRestaurants()

        rv.apply {
            adapter = RestaurantAdapter(restaurantList) {
                val intent = Intent(this@RestaurantListActivity, RestaurantActivity::class.java)
                intent.putExtra(RESTAURANT_KEY_NAME, restaurantList[it])
                startActivity(intent)
            }

            layoutManager = LinearLayoutManager(this@RestaurantListActivity)
        }
        
    }

    private fun createRestaurants(): List<Restaurant> {
        val list = mutableListOf<Restaurant>()

        for(i in 0..9) {
            var restaurant = Restaurant(
                restaurantImgAddress[i],
                Fakeit.company().name(),
        Fakeit.address().streetAddress() + ", " + Fakeit.address().city(),
       22,
               createMainCourses(i))

            list.add(restaurant)
        }

        return list
    }

    private fun createText() = mutableListOf<String>().apply {
            repeat(40) {
                add(Fakeit.lorem().words())
            }
        }.joinToString(" ")


    private fun createMainCourses(imagePosition: Int): List<MainCourse> {
        val descricao = createText()
        return mutableListOf<MainCourse>().apply {
            repeat(8) {
                add(
                        MainCourse(
                                mainCourseImgAddress[imagePosition],
                                Fakeit.food().spice(),
                                descricao)
                )}
        }
    }

    private val restaurantImgAddress: List<String> = listOf(
        "https://www.foodiesfeed.com/wp-content/uploads/2020/09/tacos-with-pulled-pork-fresh-vegetables-and-cream-413x551.jpg",
        "https://www.foodiesfeed.com/wp-content/uploads/2020/10/beef-sashimi-with-bread-413x274.jpg",
        "https://image.shutterstock.com/image-photo/image-250nw-126538544.jpg",
        "https://image.shutterstock.com/image-photo/image-250nw-62558638.jpg",
        "https://www.stockvault.net//data/2009/01/31/107573/thumb16.jpg",
        "https://www.stockvault.net//data/2009/01/31/107578/thumb16.jpg",
        "https://www.stockvault.net//data/2009/01/31/107583/thumb16.jpg",
        "https://www.stockvault.net//data/2009/01/31/107585/thumb16.jpg",
        "https://www.stockvault.net//data/2009/01/31/107584/thumb16.jpg",
        "https://www.stockvault.net//data/2009/01/31/107588/thumb16.jpg"
    )

    private val mainCourseImgAddress: List<String> = listOf(
        "https://www.stockvault.net//data/2019/05/22/265491/thumb16.jpg",
        "https://www.stockvault.net/data/2016/04/16/193507/preview16.jpg",
        "https://www.stockvault.net/data/2019/05/22/265501/preview16.jpg",
        "https://www.stockvault.net//data/2015/12/12/181589/thumb16.jpg",
        "https://www.stockvault.net/data/2013/07/20/146692/preview16.jpg",
        "https://www.stockvault.net/data/2013/04/21/144292/preview16.jpg",
        "https://www.stockvault.net/data/2007/06/04/103327/preview16.jpg",
        "https://www.stockvault.net/data/2009/01/31/107660/preview16.jpg",
        "https://www.stockvault.net/data/2009/01/31/107570/preview16.jpg",
        "https://www.stockvault.net/data/2009/01/31/107600/preview16.jpg"
    )

    companion object {
        const val RESTAURANT_KEY_NAME = "restaurant"
    }
}