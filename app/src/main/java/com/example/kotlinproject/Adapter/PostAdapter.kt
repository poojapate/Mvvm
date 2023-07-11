package com.example.kotlinproject.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinproject.Activity.LoginActivity
import com.example.kotlinproject.Activity.VideoPayerActivity
import com.example.kotlinproject.Model.AllVideoModel
import com.example.kotlinproject.Model.Data
import com.example.kotlinproject.R

class PostAdapter(val context: Context, val data: List<Data>):
    RecyclerView.Adapter<PostAdapter.pViewholder>() {

    class pViewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.r_textView)
        val user_name: TextView = itemView.findViewById(R.id.user_name)
        val current_tv: TextView = itemView.findViewById(R.id.current_tv)
        val u_thumb_iv: ImageView = itemView.findViewById(R.id.u_thumb_iv)
        val views:TextView=itemView.findViewById(R.id.views);
        val likes:TextView=itemView.findViewById(R.id.likes)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pViewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
        return pViewholder(v)
    }

    override fun onBindViewHolder(holder: pViewholder, position: Int) {
        holder.textView.text = data[position].videoTitle
        holder.user_name.text = data[position].userName
        holder.current_tv.text = data[position].uploadDate
        holder.views.text= data[position].totalViews.toString()+" views"
        holder.likes.text= data[position].totalLikes.toString()+" likes"

        val imageUrl = data[position].thumbNailUrl
        Glide.with(context)
            .load(imageUrl)
            .into(holder.u_thumb_iv)

            holder.u_thumb_iv.setOnClickListener{

           val intent=Intent(context,VideoPayerActivity::class.java)
            intent.putExtra("dd", "ff")
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size

    }
}