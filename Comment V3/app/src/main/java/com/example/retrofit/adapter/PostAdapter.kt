package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.PostResponse
import com.example.retrofit.databinding.ItemPostBinding

class PostAdapter(private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(postResponse: PostResponse){
            binding.apply{
                val text = "id: ${postResponse.id}\n" +
                        "title: ${postResponse.title}\n" +
                        "text: ${postResponse.text}"

                tvText.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        val view = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder((view))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}