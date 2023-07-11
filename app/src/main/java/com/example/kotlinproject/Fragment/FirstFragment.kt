package com.example.kotlinproject.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.kotlinproject.Activity.RecycleActivity
import com.example.kotlinproject.R


class FirstFragment : Fragment() {

  lateinit var  btn1:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first, container, false)


        btn1=view.findViewById(R.id.btn1);

        btn1.setOnClickListener{

            val intent=Intent(requireContext(),RecycleActivity::class.java)
            startActivity(intent)
        }


        return view
    }


}