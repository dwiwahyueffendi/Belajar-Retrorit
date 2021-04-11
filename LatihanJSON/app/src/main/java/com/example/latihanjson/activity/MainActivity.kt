package com.example.latihanjson.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanjson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUser.setOnClickListener {
            Intent(this@MainActivity, UserActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnPost.setOnClickListener {
            Intent(this, PostActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}