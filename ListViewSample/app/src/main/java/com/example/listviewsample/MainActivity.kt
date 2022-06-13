package com.example.listviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrName = arrayListOf<String>().apply {

            /* add("Female")
             add("Male")
             add("Others")*/

            add("Himanshu")
            add("Sudhanshu")
            add("Ram")
            add("Ramanujan")
            add("Raman")
            add("Ramdir")
            add("Himanshu")
            add("Sudhanshu")
            add("Ram")
            add("Ramanujan")
            add("Raman")
            add("Ramdir")
            add("Himanshu")
            add("Sudhanshu")
            add("Ram")
            add("Ranjan")
        }


        /* binding.listView.apply {
             adapter =
                 ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, arrNames)
             setOnItemClickListener { parent, view, position, id ->


                 when (position) {
                     0 -> {
                         Toast.makeText(this@MainActivity, "First Item Click!", Toast.LENGTH_LONG)
                             .show()

                     }

                     1 -> {
                         Toast.makeText(this@MainActivity, "Second Item Click!", Toast.LENGTH_LONG)
                             .show()

                     }
                     6 -> {
                         Toast.makeText(this@MainActivity, "Seventh Item Click!", Toast.LENGTH_LONG)
                             .show()

                     }
                 }

             }


         }*/

        /*binding.spinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrGender)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "Gender Selected as Female",
                        Toast.LENGTH_LONG
                    ).show()
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }*/


        binding.actView.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arrName
            )
        )

        binding.actView.threshold = 3
    }


}
