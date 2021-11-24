package com.bee.fresh.presentation.menu.fragments.appointment.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.ChooseModel
import com.bee.fresh.domain.model.ProfileModel
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.appointment.adapter.AppointmentAdapter
import com.bee.fresh.presentation.menu.fragments.appointment.presenter.AppointmentPresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class AppointmentFragment: BaseFragment(R.layout.appointment_fragment), AppointmentView {
    @InjectPresenter
    lateinit var presenter:AppointmentPresenter
    lateinit var chooseModel:ChooseModel
    private val router by inject<Router>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dateTextView = view.findViewById<TextView>(R.id.date)
        val chooseDate = view.findViewById<ImageView>(R.id.plusDate)
        val dateImage = view.findViewById<ImageView>(R.id.calendar)
        var output = ""
        chooseDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                output = (dayOfMonth.toString() + "." + (monthOfYear+1) + "." + (year)) + " "
                val mTimePicker: TimePickerDialog
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
                val minute = mcurrentTime.get(Calendar.MINUTE)
                mTimePicker = TimePickerDialog(requireContext(), object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        val time = (String.format("%d : %d", hourOfDay, minute))
                        output = output + time
                        dateTextView.text = output
                        dateTextView.visibility = View.VISIBLE
                        dateImage.visibility = View.VISIBLE
                    }
                }, hour, minute, true)
                mTimePicker.show()
            }, year, month, day)

            dpd.show()


        }
        val addService = view.findViewById<ImageView>(R.id.plusService)
        addService.setOnClickListener {
            router.navigateTo(Screens.chooseFragment(chooseModel))
        }
        val appointmentRecycler = view.findViewById<RecyclerView>(R.id.servicesAppointmentRecycler)
        appointmentRecycler.adapter = AppointmentAdapter(chooseModel.currentServiceModel)
        val appoint = view.findViewById<Button>(R.id.appoint)
        appoint.setOnClickListener {
            router.navigateTo(Screens.servicesFragment())
        }
    }
    companion object {
        fun newInstance(profile: ChooseModel): AppointmentFragment = AppointmentFragment().apply {
            chooseModel = profile
        }
    }
}