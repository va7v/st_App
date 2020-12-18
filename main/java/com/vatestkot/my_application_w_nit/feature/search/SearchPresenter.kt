package com.vatestkot.my_application_w_nit.feature.search

import moxy.MvpPresenter
import java.lang.Exception

class SearchPresenter: MvpPresenter<SearchView>() {
    private var selectedType: Type = Type.DAY
    fun setType(type: Type) {
        selectedType = type
    }
    private var Period: Int = 0
    fun setPeriod(days: Int) {
        Period = days
    }
    private var Latitude: Int = 0
    fun setLatitude(latitude: Int) {
        Latitude = latitude
    }
    private var Longitude: Int = 0
    fun setLongitude(longitude: Int) {
        Longitude = longitude
    }

    fun validate(period:String, latitude: String, longitude: String) {
        when {
            !PeriodIsCorrect(period) -> viewState.showPeriodError()
            !LatitudeIsCorrect(latitude) -> viewState.showLatitudeError()
            !LongitudeIsCorrect(longitude) -> viewState.showLongitudeError()
        }
    }

    private fun PeriodIsCorrect(period: String): Boolean {
        if (period.isEmpty()) return false

        return try {
            val rating = period.toInt()
            rating in 1..5
        } catch (e: Exception) {
            false
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
