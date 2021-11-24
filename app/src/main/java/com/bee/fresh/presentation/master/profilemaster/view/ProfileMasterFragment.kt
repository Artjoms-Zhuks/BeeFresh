package com.bee.fresh.presentation.master.profilemaster.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.profilemaster.presenter.ProfileMasterPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class ProfileMasterFragment: BaseFragment(R.layout.profile_master_fragment), ProfileMasterView {
    @InjectPresenter
    lateinit var presenter: ProfileMasterPresenter
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personal = view.findViewById<ImageView>(R.id.personalDataButton)
        personal.setOnClickListener {
            router.navigateTo(Screens.personalFragment())
        }
    }
    companion object {
        fun newInstance(): ProfileMasterFragment = ProfileMasterFragment()
    }
}