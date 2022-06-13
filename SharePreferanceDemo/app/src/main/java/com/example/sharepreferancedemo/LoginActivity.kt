package com.example.sharepreferancedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharepreferancedemo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            //when logged in successfully
            val shareprep = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = shareprep.edit()
            editor.putBoolean("Check", true)
            editor.apply()

            val iMain = Intent(this, MainActivity::class.java)
            startActivity(iMain)
            finish()

        }


    }
}