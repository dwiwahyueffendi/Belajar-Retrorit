package com.example.retrofit.retrofit

import com.example.retrofit.data.CommentResponse
import com.example.retrofit.data.CreatePostResponse
import com.example.retrofit.data.PostResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponse>>

    @GET("posts/2/comments")
    fun getComment(): Call<ArrayList<CommentResponse>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<CreatePostResponse>
}