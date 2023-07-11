package com.example.kotlinproject.Api

import com.example.kotlinproject.Model.AllVideoModel
import com.example.kotlinproject.Model.GetListPrimeVideoModel
import com.example.kotlinproject.Model.LoginModel
import com.example.kotlinproject.Model.signUpModelX
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("api/user/signUp")
    fun getQuotes(@Body userData: Map<String, String>): Call<signUpModelX>

    @POST("api/user/login")
    fun login(@Body loginData: Map<String, String>): Call<LoginModel>

    @GET("video/getAllVideos")
    fun getAllVideos(): Call<AllVideoModel>

    @GET("video/video/getListPrimeVideo")
    fun getListPrimeVideo(): Call<GetListPrimeVideoModel>
}