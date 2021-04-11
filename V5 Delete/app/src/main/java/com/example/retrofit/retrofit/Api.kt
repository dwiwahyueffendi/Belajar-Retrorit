package com.example.retrofit.retrofit

import com.example.retrofit.data.CommentResponse
import com.example.retrofit.data.CreatePostResponse
import com.example.retrofit.data.PostResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("posts")
    fun getPosts(
            @Query("userId") userId: Int,
            @Query("id") id: Int): Call<ArrayList<PostResponse>>

    @GET("posts")
    fun getPosts(
            @QueryMap parameters: HashMap<String, String>
    ): Call<ArrayList<PostResponse>>

    @GET
    fun getComment(@Url url: String): Call<ArrayList<CommentResponse>>

    @GET("posts/{id}/comments")
    fun getComment(@Path("id") postId: Int): Call<ArrayList<CommentResponse>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<CreatePostResponse>

    @FormUrlEncoded
    @PUT("posts/{id}")
    fun putPost(
            @Path("id") id: Int,
            @Field("userId") userId: Int,
            //@Field("id") idField: Int,
            @Field("title") title: String?,
            @Field("body") text: String?
    ): Call<PostResponse>

    @FormUrlEncoded
    @PATCH("posts/{id}")
    fun patchPost(
            @Path("id") id: Int,
            @Field("userId") userId: Int,
            //@Field("id") idField: Int,
            @Field("title") title: String?,
            @Field("body") text: String?
    ): Call<PostResponse>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Void>
}