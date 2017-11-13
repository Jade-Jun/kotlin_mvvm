package com.sy.personal.kotlin_mvvm.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sy.personal.kotlin_mvvm.R
import com.sy.personal.kotlin_mvvm.repository.data.User
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by SuYa on 2017. 11. 10..
 */
class UserRecyclerAdapter(private val context : Context, private var users : List<User>) : RecyclerView.Adapter<UserRecyclerAdapter.CustomViewHolder>(){


    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val item = users[position]
        if (null == holder) return

        holder.emailVew.text = "email : " + item.email
        holder.firstNameView.text = "first name : " + item.first
        holder.lastNameView.text = "last name : " + item.last
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val emailVew = view.email
        val firstNameView = view.first
        val lastNameView = view.last
    }

}