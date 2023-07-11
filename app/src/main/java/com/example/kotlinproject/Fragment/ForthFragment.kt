package com.example.kotlinproject.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.Adapter.PostAdapter
import com.example.kotlinproject.Adapter.PrimeAdapter
import com.example.kotlinproject.Api.RetrofitClent
import com.example.kotlinproject.Model.GetListPrimeVideoModel
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.fragment_forth.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForthFragment : Fragment() {

    lateinit var  home_list_recycler_1:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_forth, container, false)


        home_list_recycler_1=view.findViewById(R.id.home_list_recycler_1)

        GetListPrimeVideo()



        return view
    }

    private fun GetListPrimeVideo() {
        RetrofitClent.api.getListPrimeVideo().enqueue(object : Callback<GetListPrimeVideoModel?> {
            override fun onResponse(
                call: Call<GetListPrimeVideoModel?>,
                response: Response<GetListPrimeVideoModel?>) {

                if (response.body()!=null)

                    Log.d("cvbnmzxcvb nm", "onResponse: $response")
                    Log.d("cvbnmzxcvb nm", "onResponse: ${response.body()}")

                val adapter = context?.let {PrimeAdapter(it,response.body()!!) }
                home_list_recycler_1.adapter = adapter
                val layoutManager = LinearLayoutManager(context)
                home_list_recycler_1.layoutManager = layoutManager


            }

            override fun onFailure(call: Call<GetListPrimeVideoModel?>, t: Throwable) {

                Log.d("cvbnm,xcvbnm,", "onFailure: "+t.message)

            }
        })
    }


}





