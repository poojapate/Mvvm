package com.example.kotlinproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.Model.DataX

class RecycleAdapter(data: DataX) :RecyclerView.Adapter< myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle, parent, false)

        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

}
    class myViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
//        val textView: TextView = itemView.findViewById(R.id.textView)

    }
