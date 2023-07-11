package com.example.kotlinproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinproject.Model.AllVideoModel
import com.example.kotlinproject.R

class RecycleAdapter(context: Context,val items:AllVideoModel?): RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.r_textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = items?.data?.get(position)?.userName


    }

    override fun getItemCount(): Int {
        return items?.data?.size!!
    }

}