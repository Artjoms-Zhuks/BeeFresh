package com.bee.fresh.presentation.master.calendar.view

import android.os.Bundle
import android.view.View
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.calendar.presenter.CalendarPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class CalendarFragment: BaseFragment(R.layout.calendar_fragment), CalendarView {
    @InjectPresenter
    lateinit var presenter:CalendarPresenter
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calendar = view.findViewById<com.applandeo.materialcalendarview.CalendarView>(R.id.calendarView)
        calendar.setOnDayClickListener { it ->
            router.navigateTo(Screens.dateFragment(it.calendar))
        }
    }
    companion object {
        fun newInstance(): CalendarFragment = CalendarFragment()
    }
}