package com.bee.fresh.presentation.menu.fragments.masters.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.masters.adapter.MastersAdapter
import com.bee.fresh.presentation.menu.fragments.masters.presenter.MastersPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class MastersFragment: BaseFragment(R.layout.masters_fragment), MastersView {
    lateinit var choosenCategory: String
    @InjectPresenter
    lateinit var presenter:MastersPresenter
    lateinit var recycler: RecyclerView
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(),choosenCategory,Toast.LENGTH_SHORT).show()
        recycler = view.findViewById(R.id.mastersRecyclerView)
        presenter.getRecyclerItems(choosenCategory)
    }

    override fun setRecycler(items: List<MasterUiModel>) {
        val adapter = MastersAdapter(items, requireContext())
        adapter.onItemClick = {it ->
            router.navigateTo(Screens.profileFragment(it))
        }
        recycler.adapter = adapter
    }
    companion object {
        fun newInstance(category: String): MastersFragment = MastersFragment().apply {
            choosenCategory = category
        }
    }
}