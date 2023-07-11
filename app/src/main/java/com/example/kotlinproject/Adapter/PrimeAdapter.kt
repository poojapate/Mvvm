package com.example.kotlinproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinproject.Model.Data
import com.example.kotlinproject.Model.GetListPrimeVideoModel
import com.example.kotlinproject.R
import kotlinx.android.synthetic.main.prime_layout.view.*

class PrimeAdapter(val context: Context, val primeData:GetListPrimeVideoModel?): RecyclerView.Adapter<PrimeAdapter.Pviewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pviewholder {
        val v=LayoutInflater.from(context).inflate(R.layout.prime_layout,parent,false)
        return Pviewholder(v)
    }

    override fun onBindViewHolder(holder: Pviewholder, position: Int) {

        holder.Video_name_t.text=primeData!!.data.get(position).videoTitle

        Glide.with(context)
            .load(primeData.data.get(position).thumbNailUrl)
            .into(holder.Thumb_imgg)
    }

    override fun getItemCount(): Int {
       return primeData!!.data.size
    }

    class Pviewholder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val Video_name_t=itemView.Video_name_t
        val Thumb_imgg=itemView.Thumb_imgg

    }
}