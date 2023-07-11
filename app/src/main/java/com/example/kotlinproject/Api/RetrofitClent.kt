package com.example.kotlinproject.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClent {


        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("http://43.204.165.115:7076")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

            val api:ApiInterface by lazy {

            retrofit.create(ApiInterface::class.java)
        }
    }
