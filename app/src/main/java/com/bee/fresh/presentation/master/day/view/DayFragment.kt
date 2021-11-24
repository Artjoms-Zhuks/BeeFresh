package com.bee.fresh.presentation.master.day.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.master.day.presenter.DayPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class DayFragment: BaseFragment(R.layout.day_fragment), DayView {
    @InjectPresenter
    lateinit var presenter: DayPresenter
    private val router by inject<Router>()
    lateinit var data:Pair<String,String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dayOfTheWeek = view.findViewById<TextView>(R.id.dayOfTheWeek)
        dayOfTheWeek.text = getDay(data.first)
        val workTime = view.findViewById<TextView>(R.id.workTime)
        workTime.text = data.second
        val back = view.findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            router.navigateTo(Screens.sheduleFragment())
        }
        val buttonReady = view.findViewById<Button>(R.id.buttonReady)
        buttonReady.setOnClickListener {
            router.navigateTo(Screens.sheduleFragment())
        }
    }
    companion object {
        fun newInstance(dayData:Pair<String,String>): DayFragment = DayFragment().apply {
            data = dayData
        }
    }
    fun getDay(tag:String):String{
        var output = ""
        when(tag){
            "ПН" -> { output = "Понеделньик" }
            "ВТ" -> { output = "Вторник" }
            "СР" -> { output = "Среда" }
            "ЧТ" -> { output = "Четверг" }
            "ПТ" -> { output = "Пятница" }
            "СБ" -> { output = "Суббота" }
            "ВС" -> { output = "Воскресенье" }
        }
        return output
    }
}