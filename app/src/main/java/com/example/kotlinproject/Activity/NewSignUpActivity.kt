package com.example.kotlinproject.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.Api.RetrofitClent
import com.example.kotlinproject.Model.signUpModelX
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.activity_new_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewSignUpActivity : AppCompatActivity() {


    lateinit var f_name_edit: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_sign_up)


        f_name_edit=findViewById(R.id.f_name_edit)

        signup_btn.setOnClickListener{

            if(f_name_edit.text.toString().isEmpty()){
                f_name_edit.error="Enter your name"
            }
            else{



                SignUpApi()
            }

        }
    }






    private  fun SignUpApi() {

        val userData = mapOf(
            "firstName" to f_name_edit.text.toString(),
            "lastName" to l_name_edit.text.toString(),
            "email" to email_edit.text.toString(),
            "password" to pass_edit.text.toString()
        )

         RetrofitClent.api.getQuotes(userData).enqueue(object : Callback<signUpModelX?> {
         override fun onResponse(call: Call<signUpModelX?>, response: Response<signUpModelX?>) {

             Log.d("xcvb", "onResponse: " + response)
             Log.d("dfgh", "onResponse: " + response.body())

             if (response.body()!=null) {

                 Toast.makeText(this@NewSignUpActivity,response.message(), Toast.LENGTH_SHORT)
                     .show()
                 Log.d("dfghjk", "onResponse: " + response.body())

                 val intent = Intent(this@NewSignUpActivity, LoginActivity::class.java)
                 startActivity(intent)

             }
             else{
                 Toast.makeText(this@NewSignUpActivity,"nulll data", Toast.LENGTH_SHORT)
             }


         }

         override fun onFailure(call: Call<signUpModelX?>, t: Throwable) {
             Toast.makeText(this@NewSignUpActivity, "value- else", Toast.LENGTH_SHORT).show()
             Log.d("cvbnm,", "onFailure: "+t.message)
         }
     })

    }


    }
