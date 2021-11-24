package com.bee.fresh.presentation.menu.fragments.services.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.ServiceResponse
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.services.adapter.ServiceAdapter
import com.bee.fresh.presentation.menu.fragments.services.presenter.ServicesPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class ServicesFragment: BaseFragment(R.layout.sevices_fragment), ServicesView {
    @InjectPresenter
    lateinit var presenter:ServicesPresenter
    lateinit var serviceRecycler:RecyclerView
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        serviceRecycler = view.findViewById(R.id.servicesRecycler)
        presenter.getRecyclerItems()
    }
    companion object {
        fun newInstance(): ServicesFragment = ServicesFragment()
    }

    override fun setRecycler(list:List<ServiceResponse>) {
        val adapter = ServiceAdapter(list)
        adapter.onItemClick = { it ->
            router.navigateTo(Screens.detailsFragment(it))
        }
        serviceRecycler.adapter = adapter
    }
}