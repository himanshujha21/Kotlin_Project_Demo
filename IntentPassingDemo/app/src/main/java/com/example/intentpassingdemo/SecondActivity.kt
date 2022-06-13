package com.example.intentpassingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("EmailID")
        val mob = intent.getStringExtra("Mob")
        val address = intent.getStringExtra("Address")

        //tvText.text = name.toString() + "" + email.toString() + "" + mob.toString() + "" + address.toString()

        "Welcome:$name \nEmail ID: $email \nMob:$mob \nAddress:$address".also {
            tvDisplay.text = it
        }
        //tvText.text = "Welcome,${intent.getStringExtra("Name")}"


        // tvText.text = intent.getStringExtra("Name")


        val len = intent.getIntExtra("NameLn", 0)
        Toast.makeText(this, "length of $name is:$len", Toast.LENGTH_LONG).show()


    }
}