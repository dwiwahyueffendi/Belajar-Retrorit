package com.example.latihanjson.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getInstance(): ApiClient{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiInstance = retrofit.create(ApiClient::class.java)
            return apiInstance
        }
    }
}