package com.vatestkot.my_application_w_nit.feature.search

import moxy.MvpPresenter
import java.lang.Exception

class SearchPresenter: MvpPresenter<SearchView>() {
    private var selectedType: Type = Type.ONE
    fun setType(type: Type) {
        selectedType = type
    }
    private var Latitude: Int = 0
    fun setLatitude(lat_d: Int) {
        Latitude = lat_d
    }
    private var Longitude: Int = 0
    fun setLongitude(lon_d: Int) {
        Longitude = lon_d
    }

    fun validate(latitude: String, longitude: String) {
        when {
            !LatitudeIsCorrect(latitude) -> viewState.showLatitudeError()
            !LongitudeIsCorrect(longitude) -> viewState.showLongitudeError()
        }
    }

    private fun LatitudeIsCorrect(latitude: String): Boolean {
        if (latitude.isEmpty()) return false

        return try {
            val rating = latitude.toInt()
            rating in -90..90
        } catch (e: Exception) {
            false
        }
    }

    private fun LongitudeIsCorrect(longitude: String): Boolean {
        if (longitude.isEmpty()) return false

        return try {
            val rating = longitude.toInt()
            rating in -180..180
        } catch (e: Exception) {
            false
        }
    }
}