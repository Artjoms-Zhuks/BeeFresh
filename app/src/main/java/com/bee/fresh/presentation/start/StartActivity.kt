package com.bee.fresh.presentation.start

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bee.fresh.R
import com.bee.fresh.di.ciceroneDI
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.startKoin

class StartActivity: MvpAppCompatActivity() {
    private val navigatorHolder by inject<NavigatorHolder>()
    private val router by inject<Router>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        startKoin(this, listOf(ciceroneDI))
        val presenter = StartPresenter()
        val client = findViewById<Button>(R.id.clientButton)
        val master = findViewById<Button>(R.id.masterButton)
        val viewBack = findViewById<View>(R.id.view)
        client.setOnClickListener {
            client.visibility = View.GONE
            master.visibility = View.GONE
            viewBack.visibility = View.GONE
            presenter.setStartScreenClient(router, navigatorHolder, this)
        }
        master.setOnClickListener {
            client.visibility = View.GONE
            master.visibility = View.GONE
            viewBack.visibility = View.GONE
            presenter.setStartScreenMaster(router, navigatorHolder, this)
        }
    }
}