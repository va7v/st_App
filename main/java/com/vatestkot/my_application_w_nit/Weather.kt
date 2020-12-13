package com.vatestkot.my_application_w_nit

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather (val city: String, val temp: String, val clouds: String, val rainfall:String) : Parcelable