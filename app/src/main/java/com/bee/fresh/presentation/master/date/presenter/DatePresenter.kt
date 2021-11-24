package com.bee.fresh.presentation.master.date.presenter

import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.master.calendar.view.CalendarView
import com.bee.fresh.presentation.master.date.view.DateView

class DatePresenter: BasePresenter<DateView>() {
    fun getRecyclerItems() {
        val list = arrayListOf<String>()
        list.add("10:00")
        list.add("15:00")
        list.add("16:20")
        viewState.showRecycler(list)
    }
}
