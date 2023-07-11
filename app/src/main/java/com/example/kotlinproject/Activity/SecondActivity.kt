package com.example.kotlinproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinproject.Fragment.FirstFragment
import com.example.kotlinproject.Fragment.SecondFragment
import com.example.kotlinproject.R
import com.example.kotlinproject.Fragment.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    lateinit var Bottom_nav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Bottom_nav = findViewById(R.id.Bottom_nav) as BottomNavigationView
        Bottom_nav.setOnNavigationItemReselectedListener {

            when (it.itemId) {

                R.id.home -> {
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.message -> {
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.settings -> {
                    loadFragment(ThirdFragment())
                    return@setOnNavigationItemReselectedListener
                }

            }
        }
    }
          private fun loadFragment(fragment: Fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fram, fragment)
            transaction.addToBackStack(null)
                transaction.commit()
        }
    }