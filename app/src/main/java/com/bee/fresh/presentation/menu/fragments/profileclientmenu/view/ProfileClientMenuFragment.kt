package com.bee.fresh.presentation.menu.fragments.profileclientmenu.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.profile.presenter.ProfilePresenter
import com.bee.fresh.presentation.menu.fragments.profile.view.ProfileFragment
import com.bee.fresh.presentation.menu.fragments.profile.view.ProfileView
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class ProfileClientMenuFragment: BaseFragment(R.layout.profile_client_menu_fragment), ProfileClientMenuView {
    private val router by inject<Router>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save = view.findViewById<Button>(R.id.save)
        save.setOnClickListener {
            router.navigateTo(Screens.servicesFragment())
        }
    }
    companion object {
        fun newInstance(): ProfileClientMenuFragment = ProfileClientMenuFragment()
    }
}