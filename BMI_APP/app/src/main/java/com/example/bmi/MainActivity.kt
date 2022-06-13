package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //BMI--> Body Mass Index -->Person(Wt:Ht)
        //bmi = wt/(ht*ht)-->kg/m2

        btnCalculator.setOnClickListener {

            // if block is executed when the condition is true.  it is possible when these three edittext is not blank
            if (edtWeight.text.toString() != "" && edtHeight.text.toString() != "" && edtInches.text.toString() != "") {


                //fetch the data
                val wt = edtWeight.text.toString().toInt()//get the  from EditText
                val htFt = edtHeight.text.toString().toInt()// get the from EditText
                val htIn = edtInches.text.toString().toInt() // get the from EditText



                val totalIn = htFt * 12 + htIn

                // 1 inch = 2.54 cm

                val hCm = totalIn * 2.54

                //1m = 100cm
                // 1cm =1/100m

                val hM = hCm / 100

                val bmi = wt / (hM * hM)

                //navigation logic
                when {
                    bmi > 25 -> {
                        tvDisplay.text = "You are Overweight!"  //set the text

                    }
                    bmi < 18 -> {
                        tvDisplay.text = "You are Underweigh!"  //set the text

                    }
                    else -> {
                        tvDisplay.text = "You are Healthy!"   // set the text

                    }
                }


            }//end of if block

            else {
                Toast.makeText(this, "Please Fill Up all the required blanks!", Toast.LENGTH_SHORT)
                    .show()

            }


        }


    }


}