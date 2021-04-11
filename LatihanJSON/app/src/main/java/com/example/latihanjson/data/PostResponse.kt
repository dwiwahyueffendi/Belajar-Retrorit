package com.example.latihanjson.data

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)
