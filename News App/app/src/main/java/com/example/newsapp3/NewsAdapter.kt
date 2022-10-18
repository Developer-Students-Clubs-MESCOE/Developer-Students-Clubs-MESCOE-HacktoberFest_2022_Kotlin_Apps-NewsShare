package com.example.newsapp3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val listofnews : ArrayList<String>, val listner : Newsitemclicked):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val Txt_title : TextView = itemView.findViewById(R.id.Txt_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.listdesign,parent,false)
        val viewholder = ViewHolder(view)
        view.setOnClickListener {
        listner.onItemclicked(listofnews[viewholder.adapterPosition])

        }

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Txt_title.text = listofnews[position]

    }

    override fun getItemCount(): Int {
        return listofnews.size

    }
}

 interface Newsitemclicked {

     fun onItemclicked (item : String)

 }