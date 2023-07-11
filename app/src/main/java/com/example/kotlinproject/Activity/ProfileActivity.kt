package com.example.kotlinproject.Activity

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        edit_name_img.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)

        dialog.setContentView(R.layout.progress_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(true)


        val cancel =dialog.findViewById<TextView>(R.id.cancel)

        cancel.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }

}