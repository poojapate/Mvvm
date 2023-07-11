package com.example.kotlinproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.Adapter.PostAdapter

import com.example.kotlinproject.Api.RetrofitClent
import com.example.kotlinproject.Model.AllVideoModel
import com.example.kotlinproject.R
import com.example.kotlinproject.RecycleAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecycleActivity : AppCompatActivity() {


    lateinit var rcycle:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        rcycle = findViewById(R.id.rcycle)


        getAllVideos();

    }

    private fun getAllVideos() {

        RetrofitClent.api.getAllVideos().enqueue(object : Callback<AllVideoModel?> {
            override fun onResponse(call: Call<AllVideoModel?>, response: Response<AllVideoModel?>) {

                Log.d("rtyhujkil;", "onResponse: "+response.body())

                var data=response.body()


                val adapter = PostAdapter(applicationContext,response.body()!!.data)
                rcycle.adapter = adapter
                val layoutManager = LinearLayoutManager(applicationContext)
                rcycle.layoutManager = layoutManager

//                val linearLayoutManager =
//                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//                rcycle.layoutManager = linearLayoutManager
//                val postAdapter = response.body()?.let {com.example.kotlinproject.Adapter.RecycleAdapter(applicationContext!!,response.body()) }
//                rcycle.adapter = postAdapter



            }


            override fun onFailure(call: Call<AllVideoModel?>, t: Throwable) {
                Log.d("fghjkl;", "onFailure: "+t.message)
            }
        })
    }
}