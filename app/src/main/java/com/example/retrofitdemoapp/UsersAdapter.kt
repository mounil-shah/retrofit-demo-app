package com.example.retrofitdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofitdemoapp.UsersAdapter.UsersAdapterVH
import java.util.*

//    private ClickedItem clickedItem;
// replace with high order function that replaces need for interface
class UsersAdapter(private var lambdaForItemClick: (UserResponse) -> Unit)
    : RecyclerView.Adapter<UsersAdapterVH>() {
    private var userResponseList: List<UserResponse> = ArrayList()
    fun setData(userResponseList: List<UserResponse>) {
        this.userResponseList = userResponseList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapterVH {
        return UsersAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_users, parent, false))
    }

    override fun onBindViewHolder(holder: UsersAdapterVH, position: Int) {
        val currentUserResponse = userResponseList[position]
        val username = currentUserResponse.username
        val prefix: String
        prefix = if (currentUserResponse.isIs_active && username.length > 1) {
            username.substring(0, 2).toUpperCase()
        } else {
            username.substring(0, 1).toUpperCase()
        }
        holder.prefix.text = prefix
        holder.username.text = username.toUpperCase()
        holder.imageMore.setOnClickListener { lambdaForItemClick(currentUserResponse) }
    }

    override fun getItemCount(): Int {
        return userResponseList.size
    }

    inner class UsersAdapterVH(itemView: View) : ViewHolder(itemView) {
        var username: TextView
        var prefix: TextView
        var imageMore: ImageView

        init {
            username = itemView.findViewById(R.id.username)
            prefix = itemView.findViewById(R.id.prefix)
            imageMore = itemView.findViewById(R.id.imageMore)
        }
    }

}