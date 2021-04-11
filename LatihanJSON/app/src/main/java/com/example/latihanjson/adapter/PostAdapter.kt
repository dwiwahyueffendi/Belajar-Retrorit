package com.example.latihanjson.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanjson.data.PostResponse
import com.example.latihanjson.databinding.ItemListBinding

class PostAdapter(private val postList: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(postResponse: PostResponse){
            binding.apply{
                val text = "userId: ${postResponse.userId}\n" +
                        "id: ${postResponse.id}\n" +
                        "title: ${postResponse.title}\n" +
                        "text: ${postResponse.text}"

                tvResponse.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size
}