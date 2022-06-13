package com.example.intentpassingdemo

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Handle the asynchronous or parallel task execute after 4sec
        Handler().postDelayed({
            // val intent = Intent(this, MainActivity::class.java)
            startActivity(Intent(this, MainActivity::class.java))
            finish()


        }, 4000)
    }
}