package com.bee.fresh.presentation.menu.fragments.masters.presenter

import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.presentation.base.BasePresenter
import com.bee.fresh.presentation.menu.fragments.masters.view.MastersView

class MastersPresenter: BasePresenter<MastersView>() {
    fun getRecyclerItems(tag: String) {
        val list = arrayListOf<MasterUiModel>()
        when (tag) {
            "Мужская стрижка" -> {
                //Последний пункт номер картинки
                list.add(MasterUiModel("Dace Rekone", "Lubanas iela 24", 1))
                list.add(MasterUiModel("Laya Maite", "Krasta iela 67", 11))
                list.add(MasterUiModel("Maria Ulke", "Salnas iela 21", 8))
                list.add(MasterUiModel("Rafaele Tuma", "Brivibas iela 301", 6))
                list.add(MasterUiModel("Inga Ieka", "T/C Mols", 5))
            }
            "Борода" -> {
                list.add(MasterUiModel("Michail Tig", "T/C Akropole ", 1))
                list.add(MasterUiModel("Jānis Ulubele", "Aņimuižas iela 50", 1))
                list.add(MasterUiModel("Uldis Rekone", "Lubanas iela 24", 1))

            }
        }
        viewState.setRecycler(list)
    }
}