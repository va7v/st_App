package com.vatestkot.my_application_w_nit.feature.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vatestkot.my_application_w_nit.R
import kotlinx.android.synthetic.main.fragment_search.*

enum class Type { DAY, NIGHT, ALL }

class SearchFragment : Fragment(R.layout.fragment_search), SearchView {

    private val presenter = SearchPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initListener()
    }

    private fun initListener() {

        rgType.setOnCheckedChangeListener { radioGroup, i ->
            val selectedType = when (i) {
                R.id.rbOne -> Type.DAY
                R.id.rbTwo -> Type.NIGHT
                else -> Type.ALL
            }
            presenter.setType(selectedType)
        }

        btnSearch.setOnClickListener {
            val period: String = etPeriod.text.toString()
            var latitude: String = etLatitude.text.toString()
            var longitude: String = etLongitude.text.toString()

            presenter.validate(
                    period,
                    latitude,
                    longitude
            )

            if (presenter.PeriodIsCorrect(period)) {
                presenter.setPeriod(period.toInt())
            }
            if (presenter.LatitudeIsCorrect(latitude)) {
                presenter.setLatitude(latitude.toInt())
            }
            if (presenter.LongitudeIsCorrect(longitude)) {
                presenter.setLongitude(longitude.toInt())
            }
        }
    }

    override fun showPeriodError() {
        showErrorToast("Число дней")
    }

    override fun showLatitudeError() {
        showErrorToast("Широта")
    }

    override fun showLongitudeError() {
        showErrorToast("Долгота")
    }

    private fun showErrorToast(name: String) {
        Toast.makeText(requireContext(), "Ошибка в поле: $name", Toast.LENGTH_LONG).show()
    }
}
