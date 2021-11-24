package com.bee.fresh.presentation.master.date.view

import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DateView: BaseView {
    fun showRecycler(items:List<String>)
}