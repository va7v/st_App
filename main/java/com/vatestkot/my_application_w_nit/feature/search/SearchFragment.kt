package com.vatestkot.my_application_w_nit.feature.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vatestkot.my_application_w_nit.R
import kotlinx.android.synthetic.main.fragment_search.*

enum class Type { ONE, TWO, THREE }

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
                R.id.rbOne -> Type.ONE
                R.id.rbTwo -> Type.TWO
                else -> Type.THREE
            }
            presenter.setType(selectedType)
        }

        btnSearch.setOnClickListener {
            presenter.validate(
                    etPeriod.text.toString(),
                    etLatitude.text.toString(),
                    etLongitude.text.toString()
            )
            presenter.setPeriod(etPeriod.text.toString().toInt())
            presenter.setLatitude(etLatitude.text.toString().toInt())
            presenter.setLongitude(etLongitude.text.toString().toInt())
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
