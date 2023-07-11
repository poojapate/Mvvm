package com.example.kotlinproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinproject.Api.RetrofitClent
import com.example.kotlinproject.Model.LoginModel
import com.example.kotlinproject.R
import com.example.kotlinproject.sesson.Session
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    lateinit var session:Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         session= Session(this)


        login_btn.setOnClickListener {

            loginApi();
        }
    }

    private fun loginApi() {

        val loginData = mapOf(
            "email" to login_email_edit.text.toString(),
            "password" to login_password_edit.text.toString()
        )

        RetrofitClent.api.login(loginData).enqueue(object : Callback<LoginModel?> {
            override fun onResponse(call: Call<LoginModel?>, response: Response<LoginModel?>) {

                if (response.body() != null) {

                    Log.d("dfghj", "onResponse: " + response)
                    Log.d("dfghjk", "onResponse: " + response.body())

                    session.setUserId(response.body()!!.data.userId.toString())

                    Toast.makeText(this@LoginActivity, "sucess", Toast.LENGTH_SHORT).show()

                    ff_name.text = response.body()!!.data.firstName


                    val intent = Intent(this@LoginActivity, BottomActivity::class.java)
                    startActivity(intent)

                }
            }

            override fun onFailure(call: Call<LoginModel?>, t: Throwable) {
                Log.d("sdfghj", "onFailure: " + t.message)
            }
        })
    }
}