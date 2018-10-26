package com.example.android.roomdatabasekotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.my_list.view.*

class MyListAdapter : RecyclerView.Adapter<MyListAdapter.MyListViewHolder>(){

    private var adapterList:MutableList<MyList> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyListViewHolder {
        val from = LayoutInflater.from(parent.context);
        return MyListViewHolder(from.inflate(R.layout.my_list,parent,false))
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bindViewModel(adapterList[position])
    }

    fun addStuff (myList: MyList) {
        adapterList.add(myList)
        notifyDataSetChanged()
    }

    fun addStuffs (collection: List<MyList>){
        adapterList.addAll(collection)
    }

inner class MyListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    private val myListViewItem: TextView = itemView.room_textview2

    fun bindViewModel (myList:MyList){
        myListViewItem.text= myList.myToDoList
    }
    }
}