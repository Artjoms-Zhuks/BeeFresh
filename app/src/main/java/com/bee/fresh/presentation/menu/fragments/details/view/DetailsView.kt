package com.bee.fresh.presentation.menu.fragments.details.view

import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView:BaseView {
    fun setRecyclerItems(items:List<String>)
    fun setTitle(title:String)
}