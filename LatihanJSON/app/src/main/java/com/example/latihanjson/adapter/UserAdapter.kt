package com.example.latihanjson.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanjson.data.User
import com.example.latihanjson.data.UserResponse
import com.example.latihanjson.databinding.ItemListBinding

class UserAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.apply {
                val text = "Id : ${user.id}\n" +
                        "Emai : ${user.email}\n" +
                        "First Name : ${user.firstName}\n" +
                        "Last Name : ${user.lastName}\n"

                tvResponse.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

}