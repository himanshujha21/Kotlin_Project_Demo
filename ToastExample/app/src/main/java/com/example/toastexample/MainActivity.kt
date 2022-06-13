package com.example.toastexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.toastexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            showMsg("Message Toast Show")


        }
    }

    val showMsg: (msg: String) -> Unit = { msg ->
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }
}