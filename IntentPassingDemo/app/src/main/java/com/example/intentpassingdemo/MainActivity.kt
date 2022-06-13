package com.example.intentpassingdemo

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext.setOnClickListener {

            //Intent Passing


            //fetch the value from edit text
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val mob = edtMobile.text.toString()
            val address = edtAddress.text.toString()

            //val anyElementNull = listOf(name, email,mob,address ).any { it != null }

            if (name.isNotEmpty() && email.isNotEmpty() && mob.isNotEmpty() && address.isNotEmpty()) {


                val iNext = Intent(this, SecondActivity::class.java)
                //iNext.putExtra("Name", edtName.text.toString())

                //Bundle Passing
                iNext.putExtra("Name", name)
                iNext.putExtra("NameLn", name.length)
                iNext.putExtra("EmailID", email)
                if (!isValidEmail(email)) {
                    Toast.makeText(this, "please enter valid email id", Toast.LENGTH_LONG).show()
                }

                iNext.putExtra("Mob", mob)
                if (isValidPhone(mob) && mob.length < 10)
                    iNext.putExtra("Address", address)

                startActivity(iNext)
            }// end of if block

            else {
                Toast.makeText(this, "Please fill required field", Toast.LENGTH_LONG).show()

            }

        }
    }

    fun isValidEmail(str: String?): Boolean {
        return str != null && !str.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(
            str.subSequence(
                0,
                str.length
            )
        ).matches()
    }


    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPhone(Phone: String): Boolean {
        return Patterns.PHONE.matcher(Phone).matches()
    }

}