package com.example.latihanjson.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanjson.adapter.UserAdapter
import com.example.latihanjson.api.RetrofitClient
import com.example.latihanjson.data.User
import com.example.latihanjson.data.UserResponse
import com.example.latihanjson.databinding.ActivityUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private var listUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showUsers()
    }

    private fun showUsers() {
        binding.apply {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(this@UserActivity)

            RetrofitClient.getInstance().getUsers().enqueue(object: Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    tvResponeCode.text = response.code().toString()
                    val listResponse = response.body()?.data
                    listResponse?.let { listUser.addAll(it) }
                    rvUser.adapter = UserAdapter(listUser)
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    tvResponeCode.text = t.message
                }

            })
        }
    }
}