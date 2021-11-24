package com.bee.fresh.presentation.master.profileclient.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.profileclient.presenter.ProfileClientPresenter
import com.bee.fresh.presentation.master.profilemaster.presenter.ProfileMasterPresenter
import com.bee.fresh.presentation.master.profilemaster.view.ProfileMasterFragment
import com.bee.fresh.presentation.master.profilemaster.view.ProfileMasterView
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import java.util.*

class ProfileClientFragment: BaseFragment(R.layout.profile_client), ProfileClientView {
    @InjectPresenter
    lateinit var presenter: ProfileClientPresenter
    private val router by inject<Router>()
    lateinit var calendarOut:Calendar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val back = view.findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            router.navigateTo(Screens.dateFragment(calendarOut))
        }
    }
    companion object {
        fun newInstance(calendar: Calendar): ProfileClientFragment = ProfileClientFragment().apply {
            calendarOut = calendar
        }
    }
}
