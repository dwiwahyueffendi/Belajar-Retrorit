package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.CommentAdapter
import com.example.retrofit.adapter.PostAdapter
import com.example.retrofit.data.CommentResponse
import com.example.retrofit.data.CreatePostResponse
import com.example.retrofit.data.PostResponse
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var adapter: PostAdapter
    private val list = ArrayList<PostResponse>()
    private val listComment = ArrayList<CommentResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adapter = PostAdapter()

        //showPost()
        //createPost()
        showComments()
    }

    private fun showComments() {
        binding.rvPost.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvPost.setHasFixedSize(true)

        RetrofitClient.getPost()
                .getComment("posts/3/comments")
                .enqueue(object : Callback<ArrayList<CommentResponse>>{
                    override fun onResponse(call: Call<ArrayList<CommentResponse>>, response: Response<ArrayList<CommentResponse>>) {
                        binding.tvResponeCode.text = response.code().toString()
                        response.body()?.let { listComment.addAll(it) }
                        binding.rvPost.adapter = CommentAdapter(listComment)
                    }

                    override fun onFailure(call: Call<ArrayList<CommentResponse>>, t: Throwable) {
                        binding.tvResponeCode.text = t.message
                    }

                })
    }

    private fun createPost() {
        RetrofitClient.getPost().createPost(
                30,
                "Retrofit",
                "Retrofit for beginner"
        ).enqueue(object : Callback<CreatePostResponse>{
            override fun onResponse(call: Call<CreatePostResponse>, response: Response<CreatePostResponse>) {
                val responseText =  "Responde Code : ${response.code()}\n" +
                        "title : ${response.body()?.title}\n" +
                        "body : ${response.body()?.text}\n" +
                        "userId : ${response.body()?.userId}\n" +
                        "id : ${response.body()?.id}\n"

                binding.tvResponeCode.text = responseText
            }

            override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                binding.tvResponeCode.text = t.message
            }

        })
    }

    private fun showPost() {
        binding.apply {
            rvPost.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPost.setHasFixedSize(true)

            val parameters = HashMap<String, String>()
            parameters["userId"] = "6"
            parameters["id"] = "55"

            RetrofitClient.getPost()
                    .getPosts(parameters)
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
                            binding.tvResponeCode.text = t.message
                        }

                    })
        }
    }
}