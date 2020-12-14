package com.vatestkot.my_application_w_nit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import kotlinx.android.synthetic.main.fragment_weather_details.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
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

        }
    }
}