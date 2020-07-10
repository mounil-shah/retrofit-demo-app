package com.example.retrofitdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofitdemoapp.UsersAdapter.UsersAdapterVH
import kotlinx.android.synthetic.main.row_users.view.*
import java.util.*

//    private ClickedItem clickedItem;
// replace with high order function that replaces need for interface
class UsersAdapter(private val lambdaForItemClick: (UserResponse) -> Unit)
    : RecyclerView.Adapter<UsersAdapterVH>() {

    private val userResponseList = ArrayList<UserResponse>()
    fun setData(userResponseList: List<UserResponse>) {
        this.userResponseList.clear()
        this.userResponseList.addAll(userResponseList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapterVH {
        return UsersAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_users, parent, false))
    }

    override fun onBindViewHolder(holder: UsersAdapterVH, position: Int) {
        val currentUserResponse = userResponseList[position]
        val username = currentUserResponse.username
        val prefix = if (currentUserResponse.isIs_active && username.length > 1) {
            username.substring(0, 2).toUpperCase()
        } else {
            username.substring(0, 1).toUpperCase()
        }
        holder.itemView.prefix.text = prefix
        holder.itemView.username.text = username.toUpperCase()
        holder.itemView.imageMore.setOnClickListener { lambdaForItemClick(currentUserResponse) }
    }

    override fun getItemCount() = userResponseList.size

    inner class UsersAdapterVH(itemView: View) : ViewHolder(itemView)

}