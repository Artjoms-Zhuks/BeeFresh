package com.bee.fresh.presentation.menu.fragments.details.presenter

import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.menu.fragments.details.view.DetailsView
import com.bee.fresh.presentation.menu.fragments.services.view.ServicesView

class DetailsPresenter: BasePresenter<DetailsView>() {
    fun getRecyclerItems(tag:String){
        val items = arrayListOf<String>()
        when(tag){
            "Волосы" -> {
                items.add("Мужская стрижка")
                items.add("Женская стрижка")
                items.add("Покраска волос")
                items.add("Мелирование волос")
            }
            "Маникюр" -> {
                items.add("Лак")
                items.add("Гель")
            }
            "Педикюр" -> {
                items.add("Лак")
                items.add("Гель")
            }
            "Ресницы и брови" -> {
                items.add("Ресницы")
                items.add("Брови")
            }
            "Эпиляция" -> {
                items.add("Лазерная эпиляция")
                items.add("Электроэпиляция")
                items.add("Фотоэпиляция")
            }
            "Макияж" -> {
                items.add("Макияж лица")
                items.add("Макияж глаз")
                items.add("Макияж губ")
            }
            "Массаж" -> {
                items.add("Массаж спины")
                items.add("Массаж ног")
                items.add("Массаж шеи")
            }
            "Борода и усы" -> {
                items.add("Борода")
                items.add("Усы")

            }
        }
        viewState.setRecyclerItems(items)
        viewState.setTitle(tag)
    }
}