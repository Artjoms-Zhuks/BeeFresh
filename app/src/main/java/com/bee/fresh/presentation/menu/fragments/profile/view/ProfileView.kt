package com.bee.fresh.presentation.menu.fragments.profile.view

import com.bee.fresh.domain.model.ProfileModel
import com.bee.fresh.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView: BaseView {
    fun showRecycler(items:List<ProfileModel>)
}