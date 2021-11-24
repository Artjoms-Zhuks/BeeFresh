package com.bee.fresh.presentation.menu.fragments.choose.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.ChooseModel
import com.bee.fresh.domain.model.ServiceModel
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.choose.adapter.ChooseAdapter
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

class ChooseFragment: BaseFragment(R.layout.choose_fragment), ChooseView {
    lateinit var chooseModel: ChooseModel
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val serviceModel = chooseModel.profileModel.services
        val outputServiceModel = arrayListOf<ServiceModel>()
        val recycler = view.findViewById<RecyclerView>(R.id.chooseRecycler)
        val adapter = ChooseAdapter(serviceModel)
        adapter.chooseListener = { it1, it2 ->
            if (it2) {
                outputServiceModel.add(it1)
            } else {
                outputServiceModel.remove(it1)
            }
        }
        recycler.adapter = adapter
        val backToAppointment = view.findViewById<Button>(R.id.backToAppointment)
        backToAppointment.setOnClickListener {
            val outputChooseModel = ChooseModel(chooseModel.profileModel, outputServiceModel)
            router.navigateTo(Screens.appointmentFragment(outputChooseModel))
        }

    }

    companion object {
        fun newInstance(profile: ChooseModel): ChooseFragment = ChooseFragment().apply {
            chooseModel = profile
        }
    }
}