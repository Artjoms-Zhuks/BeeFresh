package com.bee.fresh.presentation.menu.fragments.profile.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bee.fresh.R
import com.bee.fresh.Screens
import com.bee.fresh.domain.model.ChooseModel
import com.bee.fresh.domain.model.MasterUiModel
import com.bee.fresh.domain.model.ProfileModel
import com.bee.fresh.domain.model.ServiceModel
import com.bee.fresh.presentation.base.BaseFragment
import com.bee.fresh.presentation.menu.fragments.profile.adapter.ProfileAdapter
import com.bee.fresh.presentation.menu.fragments.profile.presenter.ProfilePresenter
import com.github.terrakok.cicerone.Router
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject

class ProfileFragment: BaseFragment(R.layout.profile_fragment), ProfileView {
    @InjectPresenter
    lateinit var presenter: ProfilePresenter
    lateinit var choosenProfile: MasterUiModel
    lateinit var profileRecycler: RecyclerView
    lateinit var name: TextView
    lateinit var inst: TextView
    lateinit var adress: TextView
    lateinit var profileIcon:ImageView
    lateinit var profileModel: ProfileModel
    lateinit var signButton: Button
    private val router by inject<Router>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileRecycler = view.findViewById(R.id.profileSevicesRecycler)
        name = view.findViewById(R.id.masterName)
        inst = view.findViewById(R.id.instagram)
        adress = view.findViewById(R.id.adress)
        profileIcon = view.findViewById(R.id.profilePhoto)
        presenter.getRecyclerItems(choosenProfile)
        signButton = view.findViewById(R.id.signButton)
        signButton.setOnClickListener {
            val list = listOf<ServiceModel>()
            router.navigateTo(Screens.appointmentFragment(ChooseModel(profileModel, list)))
        }
    }

    override fun showRecycler(items: List<ProfileModel>) {
        profileModel = items[0]
        val adapter = ProfileAdapter(profileModel.services)
        Log.d("dsadsa", items[0].services.toString())
        name.text = items[0].masterUiModel.name
        adress.text = items[0].masterUiModel.adress
        inst.text = items[0].instagram
        when(items[0].masterUiModel.pictureCount){
            1 -> { profileIcon.setImageResource(R.drawable.image1)}
            2 -> { profileIcon.setImageResource(R.drawable.image2)}
            3 -> { profileIcon.setImageResource(R.drawable.image3)}
            4 -> { profileIcon.setImageResource(R.drawable.image4)}
            5 -> { profileIcon.setImageResource(R.drawable.image5)}
            6 -> { profileIcon.setImageResource(R.drawable.image6)}
            7 -> { profileIcon.setImageResource(R.drawable.image7)}
            8 -> { profileIcon.setImageResource(R.drawable.image8)}
            9 -> { profileIcon.setImageResource(R.drawable.image9)}
            10 -> { profileIcon.setImageResource(R.drawable.image10)}
            11 -> { profileIcon.setImageResource(R.drawable.image11)}
            12 -> { profileIcon.setImageResource(R.drawable.image12)}
        }
        profileRecycler.adapter = adapter
    }
    companion object {
        fun newInstance(profile: MasterUiModel): ProfileFragment = ProfileFragment().apply {
            choosenProfile = profile
        }
    }
}