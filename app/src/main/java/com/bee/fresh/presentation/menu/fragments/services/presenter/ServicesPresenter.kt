package com.bee.fresh.presentation.menu.fragments.services.presenter

import com.bee.fresh.domain.model.ServiceResponse
import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.menu.fragments.services.view.ServicesView

class ServicesPresenter:BasePresenter<ServicesView>() {
    fun getRecyclerItems(){
        val list = arrayListOf<ServiceResponse>()
        list.add(ServiceResponse("Волосы"))
        list.add(ServiceResponse("Маникюр"))
        list.add(ServiceResponse("Педикюр"))
        list.add(ServiceResponse("Ресницы и брови"))
        list.add(ServiceResponse("Эпиляция"))
        list.add(ServiceResponse("Макияж"))
        list.add(ServiceResponse("Массаж"))
        list.add(ServiceResponse("Борода и усы"))
        viewState.setRecycler(list)
    }
}