package com.example.latihanjson.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanjson.adapter.PostAdapter
import com.example.latihanjson.api.RetrofitClient
import com.example.latihanjson.data.PostResponse
import com.example.latihanjson.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private var listPost = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPosts()
    }

    private fun showPosts() {
        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(this@PostActivity)

            RetrofitClient.getInstance().getPosts().enqueue(object: Callback<ArrayList<PostResponse>>{
                override fun onResponse(
                    call: Call<ArrayList<PostResponse>>,
                    response: Response<ArrayList<PostResponse>>
                ) {
                    tvResponeCode.text = response.code().toString()
                    response.body()?.let { listPost.addAll(it) }
                    rvPost.adapter = PostAdapter(listPost)
                }

                override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                    tvResponeCode.text = t.message
                }

            })
        }
    }
}