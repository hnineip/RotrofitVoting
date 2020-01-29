package com.hnineiphyu.retrofitvoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hnineiphyu.retrofitvoting.R
import com.hnineiphyu.retrofitvoting.model.QueenModel

class QueenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var QueenName = itemView.findViewById<TextView>(R.id.queen_name)
    var Class = itemView.findViewById<TextView>(R.id.txt_class)
    var imgQueen = itemView.findViewById<ImageView>(R.id.queen_image)
}

class QueenAdapter (var queenList: List<QueenModel>, val context: Context):RecyclerView.Adapter<QueenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_queeen, parent, false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.QueenName.text = queenList[position].name
        holder.Class.text = queenList[position].jsonMemberClass

        Glide.with(context).load(queenList[position].imgUrl)
            .into(holder.imgQueen)
    }
}