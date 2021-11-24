package com.bee.fresh.presentation.menu.fragments.details.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.ServiceResponse
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.details.adapter.DetailsAdapter
import com.bee.fresh.presentation.menu.fragments.details.presenter.DetailsPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class DetailsFragment: BaseFragment(R.layout.details_layout), DetailsView {
    @InjectPresenter
    lateinit var presenter: DetailsPresenter
    private val router by inject<Router>()
    lateinit var titleTextView: TextView
    lateinit var detailsRecycler: RecyclerView
    lateinit var serviceResponse: ServiceResponse
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsRecycler = view.findViewById(R.id.detailsRecycler)
        titleTextView = view.findViewById(R.id.title)
        Toast.makeText(requireContext(), serviceResponse.serviceName, Toast.LENGTH_SHORT).show()
        presenter.getRecyclerItems(serviceResponse.serviceName)
    }


    override fun setRecyclerItems(items: List<String>) {
        val adapter = DetailsAdapter(items)
        adapter.onItemClick = { it ->
            router.navigateTo(Screens.mastersFragment(it))
        }
        detailsRecycler.adapter = adapter
    }

    override fun setTitle(title: String) {
        titleTextView.text = title
    }

    companion object {
        fun newInstance(service: ServiceResponse): DetailsFragment = DetailsFragment().apply {
            serviceResponse = service
        }
    }
}