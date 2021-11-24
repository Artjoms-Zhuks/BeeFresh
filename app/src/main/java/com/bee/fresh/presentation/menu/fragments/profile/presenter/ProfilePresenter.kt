package com.bee.fresh.presentation.menu.fragments.profile.presenter

import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.domain.model.ProfileModel
import com.bee.fresh.domain.model.ServiceModel
import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.menu.fragments.profile.view.ProfileView

class ProfilePresenter: BasePresenter<ProfileView>() {
    fun getRecyclerItems(master: MasterUiModel) {
        val items = arrayListOf<ProfileModel>()
        val servicesList = arrayListOf<ServiceModel>()
        when (master.name) {
            "Dace Rekone" -> {
                servicesList.add(ServiceModel("Мужская стрижка", "15€"))
                servicesList.add(ServiceModel("Женская стрижка", "40€"))
                servicesList.add(ServiceModel("Мелирование волос", "80€"))
                servicesList.add(ServiceModel("Педикюр", "30€"))
                servicesList.add(ServiceModel("Маникюр", "25€"))
                items.add(ProfileModel("daceRekone", servicesList, master))
            }
        }
        viewState.showRecycler(items)
    }
}