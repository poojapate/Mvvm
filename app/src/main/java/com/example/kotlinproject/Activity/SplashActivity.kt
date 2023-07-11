package com.example.kotlinproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.kotlinproject.R
import com.example.kotlinproject.sesson.Session

class SplashActivity : AppCompatActivity() {

    lateinit var session: Session

    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        session= Session(this)

        handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            showToast()
        }, 3000)

    }

    private fun showToast() {

        if (session.getUserId().isEmpty()){

            val intent= Intent(this,NewSignUpActivity::class.java)
            startActivity(intent)
        }
        else{

            val intent=Intent(this,BottomActivity::class.java)
            startActivity(intent)
        }


    }
}