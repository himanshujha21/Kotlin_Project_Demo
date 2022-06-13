package com.example.sharepreferancedemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splase)

        Handler().postDelayed({ proceedNext() }, 4000)


    }

    fun proceedNext() {
        val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
        var check = sharedPref.getBoolean("Check", false)

        lateinit var iNext: Intent


        //(here check return true)  check :true
        if (check) {
            iNext =
                Intent(this, MainActivity::class.java)//if value true then navigate to MainActivity

        } else {
            iNext = Intent(this, LoginActivity::class.java)
        }

        startActivity(iNext)
        finish()

    }
}