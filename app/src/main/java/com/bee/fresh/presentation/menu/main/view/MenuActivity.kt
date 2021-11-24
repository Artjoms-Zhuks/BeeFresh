package com.bee.fresh.presentation.menu.main.view

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.menu.main.presenter.MenuPresenter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject

class MenuActivity: MvpAppCompatActivity(), MenuView {
    private val navigatorHolder by inject<NavigatorHolder>()
    private val router by inject<Router>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)
        val presenter = MenuPresenter()
        presenter.setStartScreen(router,navigatorHolder,this)
        val profile = findViewById<ImageView>(R.id.profile)
        val search = findViewById<ImageView>(R.id.search)
        search.setOnClickListener {
            router.navigateTo(Screens.servicesFragment())
        }
        profile.setOnClickListener {
            router.navigateTo(Screens.profileClientMenuFragment())
        }
    }
}