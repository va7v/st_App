package com.vatestkot.my_application_w_nit.feature.search

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.Skip

@AddToEnd
interface SearchView : MvpView {

    fun showLatitudeError()

    fun showLongitudeError()
}