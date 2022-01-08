package com.shinto.netflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shinto.netflix.Model.MovieResponce
import com.shinto.netflix.Model.Result
import com.shinto.netflix.R

class NetflixAdapter:RecyclerView.Adapter<NetflixAdapter.NetflixViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NetflixAdapter.NetflixViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.filmcard,parent,false)
        return NetflixViewHolder(view)
    }

    inner class NetflixViewHolder(view: View):RecyclerView.ViewHolder(view){
        val filmcardimage: ImageView = view.findViewById<ImageView>(R.id.filmcardimage)
    }

    private val diffcallback = object :DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
    val differ=AsyncListDiffer(this,diffcallback)

    override fun onBindViewHolder(holder: NetflixAdapter.NetflixViewHolder, position: Int) {
        val imageDiff=differ.currentList[position]
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${imageDiff.poster_path}").
                into(holder.filmcardimage)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(imageDiff) }
        }
    }
    private var onItemClickListener:((Result)->Unit)? =null

    fun setOnClickListner(listener:(Result)->Unit){
        onItemClickListener=listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}