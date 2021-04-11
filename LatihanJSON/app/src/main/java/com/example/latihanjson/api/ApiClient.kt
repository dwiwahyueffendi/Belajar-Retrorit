package com.example.latihanjson.api

import com.example.latihanjson.data.PostResponse
import com.example.latihanjson.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("users")
    fun getUsers(): Call<UserResponse>

    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getPosts(): Call<ArrayList<PostResponse>>
}