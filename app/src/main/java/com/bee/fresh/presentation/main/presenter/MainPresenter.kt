package com.bee.fresh.presentation.main.presenter

import androidx.fragment.app.FragmentActivity
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainPresenter {
    fun setStartScreen(router: Router, navigatorHolder: NavigatorHolder, activity: FragmentActivity) {
        setNavigatorHolder(activity, navigatorHolder)
        startScreen(router)
    }

    private fun startScreen(router: Router) {
        router.navigateTo(Screens.loginClientFragment())
    }

    private fun setNavigatorHolder(activity: FragmentActivity, navigatorHolder: NavigatorHolder) {
        val navigator = AppNavigator(activity, R.id.main_container)
        navigatorHolder.setNavigator(navigator)
    }
}