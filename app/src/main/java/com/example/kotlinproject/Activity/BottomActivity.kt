package com.example.kotlinproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinproject.Fragment.*
import com.example.kotlinproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {

    lateinit var  bottomNav:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        bottomNav=findViewById(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(FirstFragment())
                    true
                }
                R.id.message -> {
                    loadFragment(SecondFragment())
                    true
                }
                R.id.settings -> {
                    loadFragment(ThirdFragment())
                    true
                }

                R.id.Prime-> {
                    loadFragment(ForthFragment())
                    true
                }

                else -> false
            }
        }


    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()

    }

    }
