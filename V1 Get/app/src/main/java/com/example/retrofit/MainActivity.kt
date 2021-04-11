package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var adapter: PostAdapter
    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adapter = PostAdapter()

        binding.apply {
            rvPost.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPost.setHasFixedSize(true)

            RetrofitClient.getPost()
                .getPosts()
                .enqueue(object: Callback<ArrayList<PostResponse>>{
                    override fun onResponse(
                        call: Call<ArrayList<PostResponse>>,
                        response: Response<ArrayList<PostResponse>>
                    ) {
                        val responseCode = response.code().toString()
                        tvResponeCode.text = responseCode
                        response.body()?.let { list.addAll(it) }
                        val adapter = PostAdapter(list)
                        rvPost.adapter = adapter
                    }

                    override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

                    }

                })
        }
    }
}