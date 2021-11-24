package com.bee.fresh.presentation.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bee.fresh.R
import com.bee.fresh.di.ciceroneDI
import com.bee.fresh.presentation.main.presenter.MainPresenter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.startKoin

class MainActivity: MvpAppCompatActivity() {
    private val navigatorHolder by inject<NavigatorHolder>()
    private val router by inject<Router>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin(this, listOf(ciceroneDI))
        val presenter = MainPresenter()
        presenter.setStartScreen(router,navigatorHolder,this)
    }
}