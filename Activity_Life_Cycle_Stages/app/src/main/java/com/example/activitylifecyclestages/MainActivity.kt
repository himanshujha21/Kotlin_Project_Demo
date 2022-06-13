package com.example.activitylifecyclestages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "THISACT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("Activity created!")

        btnNext.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            //startActivity(Intent(this, SecondActivity::class.java))
        })
    }

    override fun onStart() {
        super.onStart()
        log("Activity Started!")
    }


    override fun onPause() {
        super.onPause()
        log("Activity Pause!")
    }

    override fun onResume() {
        super.onResume()
        log("Activity Resume!")
    }

    override fun onPostResume() {
        super.onPostResume()
        log("Activity  after resumed!")
    }

    override fun onRestart() {
        super.onRestart()
        log("Activity restarted!")
    }

    override fun onStop() {
        super.onStop()
        log("Activity Stopped!")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("Activity destroyed!")
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        log("User Interacted!")
    }

    val log = { MSG: String -> Log.d(TAG, MSG) }


}