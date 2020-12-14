package com.vatestkot.my_application_w_nit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather

class FavoritiesFragment : Fragment(R.layout.fragment_weather_details) {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weather: Weather) =
                WeatherDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(WEATHER, weather)
                    }
                }
    }

}