package com.example.retrofit.data

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    @SerializedName("body")
    val commentText: String
)
