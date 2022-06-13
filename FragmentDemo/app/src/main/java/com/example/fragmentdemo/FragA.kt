package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdemo.databinding.FragABinding


class FragA : Fragment() {
    private var binding: FragABinding? = null

    companion object {
        val ARGUMENT1 = "Argument1"
        val ARGUMENT2 = "Argument2"

        fun getInstance(name: String, no: Int): FragA {

            val aFrag = FragA()
            val bundle = Bundle()
            bundle.putString(ARGUMENT1, name)
            bundle.putInt(ARGUMENT2, no)
            aFrag.arguments = bundle

            return aFrag

        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        //typecasting
        (activity as MainActivity).fromFrag("Himanshu")


        binding = FragABinding.inflate(inflater, container, false)
        val view = binding!!.root
        /*requireArguments().let {
            val name = it.getString(ARGUMENT1)
            val no = it.getInt(ARGUMENT2)
            binding!!.tv.text = "$name $no"


        }

*/
        binding!!.tv.text = (activity as MainActivity).name

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}