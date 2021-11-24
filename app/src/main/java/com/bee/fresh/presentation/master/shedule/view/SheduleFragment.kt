package com.bee.fresh.presentation.master.shedule.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.shedule.adapter.SheduleAdapter
import com.bee.fresh.presentation.master.shedule.presenter.ShedulePresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class SheduleFragment: BaseFragment(R.layout.shedule_fragment), SheduleView {
    @InjectPresenter
    lateinit var presenter: ShedulePresenter
    private val router by inject<Router>()
    lateinit var sheduleRecycler: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sheduleRecycler = view.findViewById(R.id.sheduleRecyclerView)
        presenter.getRecyclerItems()
        val back = view.findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            router.navigateTo(Screens.personalFragment())
        }
    }

    companion object {
        fun newInstance(): SheduleFragment = SheduleFragment()
    }

    override fun showRecycler(items: List<Pair<String, String>>) {
        val adapter = SheduleAdapter(items)
        adapter.onItemClick = {it ->
            router.navigateTo(Screens.dayFragment(it))
        }
        sheduleRecycler.adapter = adapter
    }
}