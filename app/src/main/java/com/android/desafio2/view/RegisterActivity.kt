package com.android.desafio2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.desafio2.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.mbRegister1).setOnClickListener {
            val intent = Intent(this, RestaurantListActivity::class.java)
            startActivity(intent)
        }
    }
}