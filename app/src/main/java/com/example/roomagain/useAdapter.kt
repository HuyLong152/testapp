package com.example.roomagain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class useAdapter(val list: List<user>) :RecyclerView.Adapter<useAdapter.users>() {

    private var lists: List<user> = list
    inner class users(itemView:View) :RecyclerView.ViewHolder(itemView)

    fun setData( lists : List<user>) {
        this.lists = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): users {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return users(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: users, position: Int) {
        holder.itemView.apply {
            val txtName = findViewById<TextView>(R.id.txtUserN)
            val txtAdd = findViewById<TextView>(R.id.txtUserAdd)
            txtName.text = list[position].userName
            txtAdd.text = list[position].userAdd
        }
    }
}