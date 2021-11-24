package com.bee.fresh.presentation.menu.fragments.profileclientmenu.view

import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileClientMenuView:BaseView {
}