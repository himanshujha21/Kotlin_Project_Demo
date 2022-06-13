package com.example.jetpacknavigationgraphsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.frag_a.view.*


class FragA : Fragment() {
    //global variable as late intialization
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_a, container, false)

        view.btnFragAtoB.setOnClickListener {
            navController.navigate(R.id.action_fragA_to_fragB)

        }

        view.btnFragAtoC.setOnClickListener {
            navController.navigate(R.id.action_fragA_to_fragC)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

}