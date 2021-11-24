package com.bee.fresh.presentation.master.personal.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.calendar.presenter.CalendarPresenter
import com.bee.fresh.presentation.master.personal.presenter.PersonalPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class PersonalFragment: BaseFragment(R.layout.personal_fragment), PersonalView {
    @InjectPresenter
    lateinit var presenter: PersonalPresenter
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calendar = view.findViewById<ImageView>(R.id.calendar)
        calendar.setOnClickListener {
            router.navigateTo(Screens.sheduleFragment())
        }
        val calendarText = view.findViewById<TextView>(R.id.calendarText)
        calendarText.setOnClickListener {
            router.navigateTo(Screens.sheduleFragment())
        }
    }
    companion object {
        fun newInstance(): PersonalFragment = PersonalFragment()
    }
}