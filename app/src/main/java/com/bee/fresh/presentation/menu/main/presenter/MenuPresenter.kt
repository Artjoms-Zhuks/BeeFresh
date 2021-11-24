package com.bee.fresh.presentation.menu.main.presenter

import androidx.fragment.app.FragmentActivity
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.menu.main.view.MenuView
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class MenuPresenter : BasePresenter<MenuView>() {
    fun setStartScreen(router: Router, navigatorHolder: NavigatorHolder, activity: FragmentActivity) {
        setNavigatorHolder(activity, navigatorHolder)
        startScreen(router)
    }

    private fun startScreen(router: Router) {
        router.navigateTo(Screens.servicesFragment())
    }

    private fun setNavigatorHolder(activity: FragmentActivity, navigatorHolder: NavigatorHolder) {
        val navigator = AppNavigator(activity, R.id.menuContainer)
        navigatorHolder.setNavigator(navigator)
    }
}