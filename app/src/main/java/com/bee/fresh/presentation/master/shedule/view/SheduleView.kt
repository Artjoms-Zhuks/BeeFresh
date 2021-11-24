package com.bee.fresh.presentation.master.shedule.view

import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SheduleView:BaseView {
    fun showRecycler(items:List<Pair<String,String>>)
}