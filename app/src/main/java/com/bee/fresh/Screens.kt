package com.bee.fresh

import com.bee.fresh.domain.model.ChooseModel
import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.domain.model.ServiceResponse
import com.bee.fresh.presentation.auth.loginclient.view.LoginFragmentClient
import com.bee.fresh.presentation.auth.loginmaster.view.LoginFragmentMaster
import com.bee.fresh.presentation.master.calendar.view.CalendarFragment
import com.bee.fresh.presentation.master.date.view.DateFragment
import com.bee.fresh.presentation.master.day.view.DayFragment
import com.bee.fresh.presentation.master.personal.view.PersonalFragment
import com.bee.fresh.presentation.master.profileclient.view.ProfileClientFragment
import com.bee.fresh.presentation.master.profilemaster.view.ProfileMasterFragment
import com.bee.fresh.presentation.master.shedule.view.SheduleFragment
import com.bee.fresh.presentation.menu.fragments.appointment.view.AppointmentFragment
import com.bee.fresh.presentation.menu.fragments.choose.view.ChooseFragment
import com.bee.fresh.presentation.menu.fragments.details.view.DetailsFragment
import com.bee.fresh.presentation.menu.fragments.masters.view.MastersFragment
import com.bee.fresh.presentation.menu.fragments.profile.view.ProfileFragment
import com.bee.fresh.presentation.menu.fragments.profileclientmenu.view.ProfileClientMenuFragment
import com.bee.fresh.presentation.menu.fragments.services.view.ServicesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import java.util.*

object Screens {
    fun loginClientFragment() = FragmentScreen { LoginFragmentClient.newInstance() }
    fun servicesFragment() = FragmentScreen { ServicesFragment.newInstance() }
    fun detailsFragment(service: ServiceResponse) = FragmentScreen { DetailsFragment.newInstance(service) }
    fun mastersFragment(category: String) = FragmentScreen { MastersFragment.newInstance(category) }
    fun profileFragment(profile: MasterUiModel) = FragmentScreen { ProfileFragment.newInstance(profile) }
    fun appointmentFragment(profile: ChooseModel) = FragmentScreen { AppointmentFragment.newInstance(profile) }
    fun chooseFragment(chooseModel: ChooseModel) = FragmentScreen { ChooseFragment.newInstance(chooseModel) }
    fun calendarFragment() = FragmentScreen { CalendarFragment.newInstance() }
    fun dateFragment(calendar: Calendar) = FragmentScreen { DateFragment.newInstance(calendar) }
    fun dayFragment(data: Pair<String, String>) = FragmentScreen { DayFragment.newInstance(data) }
    fun personalFragment() = FragmentScreen { PersonalFragment.newInstance() }
    fun profileFragment() = FragmentScreen { ProfileMasterFragment.newInstance() }
    fun sheduleFragment() = FragmentScreen { SheduleFragment.newInstance() }
    fun clientMasterFragment(calendar: Calendar) = FragmentScreen { ProfileClientFragment.newInstance(calendar) }
    fun loginFragmentMaster() = FragmentScreen { LoginFragmentMaster.newInstance() }
    fun profileClientMenuFragment() = FragmentScreen { ProfileClientMenuFragment.newInstance() }
}