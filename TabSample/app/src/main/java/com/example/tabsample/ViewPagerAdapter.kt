package com.example.tabsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {

        return 3

    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragA()
            }
            1 -> {
                FragB()

            }
            else -> {
                FragC()
            }
        }


    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Tab1"
            }
            1 -> {
                "Tab2"

            }
            else -> {
                "Tab3"
            }
        }


    }

}