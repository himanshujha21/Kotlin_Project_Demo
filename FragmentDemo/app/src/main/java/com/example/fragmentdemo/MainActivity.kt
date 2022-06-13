package com.example.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.fragmentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Default
        loadFragment(FragB(), true)


        binding.btnFragA.setOnClickListener {
            /*val fm = supportFragmentManager//  fragment manager always get from activity class
            val ft = fm.beginTransaction()//fragment transaction get call from fragment manager
            ft.add(R.id.container, FragA())//load the Frag A
            ft.commit()
           */
            /* val afrag = FragA()
             val bundle = Bundle()
             bundle.putString("Argument1", "Himanshu")
             bundle.putInt("Argument2", 9)
             afrag.arguments = bundle*/

            loadFragment(FragA.getInstance("Himanshu", 9), false)
        }



        binding.btnFragB.setOnClickListener {
            loadFragment(FragB(), false)

        }

        binding.btnFragC.setOnClickListener {
            loadFragment(FragC(), false)

        }


    }

    fun loadFragment(fragment: Fragment, flag: Boolean) {
        val fm = supportFragmentManager//  fragment manager always get from activity class
        val ft = fm.beginTransaction()//fragment transaction get call from fragment manager
        if (flag)
            ft.add(R.id.container, fragment)//load the Frag A
        else
            ft.replace(R.id.container, fragment)
        ft.commit()

    }

    fun fromFrag(name: String) {
        this.name = name
        Log.d("InAct", "FromFragment $name")

    }
}