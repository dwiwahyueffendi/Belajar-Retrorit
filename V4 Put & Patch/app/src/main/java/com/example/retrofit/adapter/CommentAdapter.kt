package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.CommentResponse
import com.example.retrofit.databinding.ItemPostBinding

class CommentAdapter(private val listComment: ArrayList<CommentResponse>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    inner class CommentViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(commentResponse: CommentResponse) {
            val text1 = "PostId : ${commentResponse.postId}\n" +
                    "Id : ${commentResponse.id}\n" +
                    "Name : ${commentResponse.name}" +
                    "Email : ${commentResponse.email}" +
                    "Comment : ${commentResponse.commentText}"

            binding.tvText.text = text1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder((view))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(listComment[position])
    }

    override fun getItemCount(): Int = listComment.size
}