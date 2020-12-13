package com.vatestkot.my_application_w_nit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import kotlinx.android.synthetic.main.fragment_weather_details.*

class WeatherDetailsFragment : Fragment(R.layout.fragment_weather_details) {

    companion object {

        private const val WEATHER = "WEATHER"

        fun newInstance(weather: Weather) =
                WeatherDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(WEATHER, weather)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val weather = it.getParcelable<Weather>(WEATHER)
            cityName.text = "City: ${weather?.city}"
            tempC.text = "Tepreture: ${weather?.temp}"
            Clouds.text = "City: ${weather?.clouds}"
            Rainfall.text = "Tepreture: ${weather?.rainfall}"
        }
    }
}