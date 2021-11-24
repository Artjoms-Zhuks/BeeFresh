package com.bee.fresh.presentation.auth.loginmaster.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bee.fresh.R
import com.bee.fresh.presentation.auth.loginclient.view.LoginFragmentClient
import com.bee.fresh.presentation.auth.loginclient.view.LoginViewClient
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.activity.MasterActivity
import com.bee.fresh.presentation.menu.main.view.MenuActivity
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

class LoginFragmentMaster: BaseFragment(R.layout.login_fragment), LoginViewMaster {
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginButton = view.findViewById<Button>(R.id.logInButton)
        loginButton.setOnClickListener {
            val intent = Intent(context, MasterActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): LoginFragmentMaster = LoginFragmentMaster()
    }
}