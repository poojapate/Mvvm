package com.example.kotlinproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlinproject.R


class NewFragment : Fragment() {

    private lateinit var textView:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_new, container, false)

        textView = view.findViewById<View>(R.id.textView) as TextView
        val bundle = arguments
        val message = bundle!!.getString("message")
        textView.text = message
        return view
    }


    }
