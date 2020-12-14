package com.vatestkot.my_application_w_nit.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import kotlinx.android.synthetic.main.fragment_top_weather.*

class TopWeatherFragment : Fragment(R.layout.fragment_top_weather) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = Weather("Челябинск", "-7", "Ясно","Снег")

        btnGoToDetails.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        }
        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container,SearchFragment.newInstance(weather))
                .addToBackStack("SearchFragment")
                .commit()
        }
        btnGoToFavorities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container,FavoritiesFragment.newInstance(weather))
                    .addToBackStack("FavoritiesFragment")
                    .commit()
        }
    }
}