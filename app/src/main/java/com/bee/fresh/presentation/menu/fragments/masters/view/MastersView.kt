package com.bee.fresh.presentation.menu.fragments.masters.view

import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MastersView: BaseView {
    fun setRecycler(items: List<MasterUiModel>)
}