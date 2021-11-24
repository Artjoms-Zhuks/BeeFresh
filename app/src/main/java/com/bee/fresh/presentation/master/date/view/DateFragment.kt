package com.bee.fresh.presentation.master.date.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.date.adapter.DateAdapter
import com.bee.fresh.presentation.master.date.presenter.DatePresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import java.util.*

class DateFragment: BaseFragment(R.layout.date_fragment), DateView {
    @InjectPresenter
    lateinit var presenter: DatePresenter
    private val router by inject<Router>()
    lateinit var dateRecycler: RecyclerView
    lateinit var calendar: Calendar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dateText = view.findViewById<TextView>(R.id.date)
        dateRecycler = view.findViewById(R.id.dateRecycler)
        dateText.text = calendar.get(Calendar.DAY_OF_MONTH).toString() + " " + getMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR).toString()
        presenter.getRecyclerItems()
        val back = view.findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            router.navigateTo(Screens.calendarFragment())
        }
    }

    companion object {
        fun newInstance(calendar: Calendar): DateFragment = DateFragment().apply {
            this.calendar = calendar
        }
    }

    fun getMonth(tag: Int): String {
        var output = ""
        when (tag) {
            0 -> {
                output = "Января"
            }
            1 -> {
                output = "Февраля"
            }
            2 -> {
                output = "Марта"
            }
            3 -> {
                output = "Апреля"
            }
            4 -> {
                output = "Мая"
            }
            5 -> {
                output = "Июня"
            }
            6 -> {
                output = "Июля"
            }
            7 -> {
                output = "Августа"
            }
            8 -> {
                output = "Сентября"
            }
            9 -> {
                output = "Октября"
            }
            10 -> {
                output = "Ноября"
            }
            11 -> {
                output = "Декабря"
            }
        }
        return output

    }

    override fun showRecycler(items: List<String>) {
        val adapter = DateAdapter(items)
        adapter.onClickButton = {
            router.navigateTo(Screens.clientMasterFragment(calendar))
        }
        dateRecycler.adapter = adapter
    }
}