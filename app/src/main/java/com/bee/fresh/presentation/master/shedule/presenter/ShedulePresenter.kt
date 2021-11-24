package com.bee.fresh.presentation.master.shedule.presenter

import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.master.personal.view.PersonalView
import com.bee.fresh.presentation.master.shedule.view.SheduleView

class ShedulePresenter: BasePresenter<SheduleView>()  {
    fun getRecyclerItems(){
        val list = ArrayList<Pair<String,String>>()
        list.add(Pair("ПН", "10:00-19:00"))
        list.add(Pair("ВТ", "8:00-17:00"))
        list.add(Pair("СР", "12:00-21:00"))
        list.add(Pair("ЧТ", "10:00-19:00"))
        list.add(Pair("ПТ", "12:00-21:00"))
        list.add(Pair("СБ", "15:00-19:00"))
        viewState.showRecycler(list)
    }
}