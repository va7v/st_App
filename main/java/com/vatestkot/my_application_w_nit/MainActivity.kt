package com.vatestkot.my_application_w_nit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vatestkot.my_application_w_nit.ui.TopWeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.container, TopWeatherFragment())
            .commit()
    }
}