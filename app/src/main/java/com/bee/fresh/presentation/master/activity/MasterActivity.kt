package com.bee.fresh.presentation.master.activity

import android.os.Bundle
import android.widget.ImageView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.menu.main.presenter.MenuPresenter
import com.bee.fresh.presentation.menu.main.view.MenuView
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject

class MasterActivity: MvpAppCompatActivity(), MenuView {
    private val navigatorHolder by inject<NavigatorHolder>()
    private val router by inject<Router>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.master_activity)
        val presenter = MasterPresenter()
        presenter.setStartScreen(router,navigatorHolder,this)
        val calendar = findViewById<ImageView>(R.id.calendar)
        calendar.setOnClickListener {
            router.navigateTo(Screens.calendarFragment())
        }
        val profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            router.navigateTo(Screens.profileFragment())
        }
    }
}