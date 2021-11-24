package com.bee.fresh.presentation.menu.fragments.services.view

import com.bee.fresh.domain.model.ServiceResponse
import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ServicesView:BaseView {
    fun setRecycler(list:List<ServiceResponse>)
}