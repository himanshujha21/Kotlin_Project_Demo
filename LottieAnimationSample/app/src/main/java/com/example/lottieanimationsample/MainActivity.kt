package com.example.lottieanimationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lottieanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {

            binding.lottieView.setAnimation(R.raw.animation)
            binding.lottieView.repeatCount = 1000
            binding.lottieView.loop(true)
            binding.lottieView.playAnimation()

        }
    }
}