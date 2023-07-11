package com.example.kotlinproject.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlinproject.Fragment.CricketFragment
import com.example.kotlinproject.Fragment.FootballFragment
import com.example.kotlinproject.Fragment.NBAFragment

@Suppress("DEPRECATION")
internal class MyAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int) :

    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FootballFragment()
            }
            1 -> {
                CricketFragment()
            }
            2 -> {
                NBAFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return 3
    }
}