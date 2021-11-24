package com.bee.fresh.presentation.master.activity

import androidx.fragment.app.FragmentActivity
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class MasterPresenter {
    fun setStartScreen(router: Router, navigatorHolder: NavigatorHolder, activity: FragmentActivity) {
        setNavigatorHolder(activity, navigatorHolder)
        startScreen(router)
    }

    private fun startScreen(router: Router) {
        router.navigateTo(Screens.calendarFragment())
    }

    private fun setNavigatorHolder(activity: FragmentActivity, navigatorHolder: NavigatorHolder) {
        val navigator = AppNavigator(activity, R.id.masterContainer)
        navigatorHolder.setNavigator(navigator)
    }
}