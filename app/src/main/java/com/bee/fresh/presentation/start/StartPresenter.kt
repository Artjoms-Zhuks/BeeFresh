package com.bee.fresh.presentation.start

import androidx.fragment.app.FragmentActivity
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class StartPresenter {
    fun setStartScreenMaster(router: Router, navigatorHolder: NavigatorHolder, activity: FragmentActivity) {
        setNavigatorHolder(activity, navigatorHolder)
        startScreenMaster(router)
    }
    fun setStartScreenClient(router: Router, navigatorHolder: NavigatorHolder, activity: FragmentActivity) {
        setNavigatorHolder(activity, navigatorHolder)
        startScreenClient(router)}

    private fun startScreenMaster(router: Router) {
        router.navigateTo(Screens.loginFragmentMaster())
    }
    private fun startScreenClient(router: Router) {
        router.navigateTo(Screens.loginClientFragment())
    }

    private fun setNavigatorHolder(activity: FragmentActivity, navigatorHolder: NavigatorHolder) {
        val navigator = AppNavigator(activity, R.id.startContainer)
        navigatorHolder.setNavigator(navigator)
    }
}