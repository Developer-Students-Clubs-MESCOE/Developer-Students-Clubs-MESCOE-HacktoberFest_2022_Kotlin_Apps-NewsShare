package com.example.newsapp3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), Newsitemclicked {

    lateinit var rec : RecyclerView
    var adapter : NewsAdapter ?= null
    val lisofnews = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rec = findViewById(R.id.Recyclerview)
        rec.setHasFixedSize(true)
        rec.layoutManager = LinearLayoutManager(this)

        val item = fetchdata()
        adapter = NewsAdapter(item,this)
        rec.adapter = adapter
        adapter!!.notifyDataSetChanged()

    }

    fun fetchdata ():ArrayList<String>{

        val list = ArrayList<String>()
        for (i in 0 until 100 step 1){
            list.addAll(listOf("Item $i"))
        }

        return list
    }

    override fun onItemclicked(item: String) {
        Toast.makeText(this@MainActivity, "Itemclicked $item" , Toast.LENGTH_LONG).show()
    }

}

 