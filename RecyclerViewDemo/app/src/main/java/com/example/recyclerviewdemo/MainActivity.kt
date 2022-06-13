package com.example.recyclerviewdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityMainBinding
import com.example.recyclerviewdemo.databinding.DialogAddUpdateBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val arrayData = arrayListOf<ContactModel>(

            ContactModel(R.drawable.male, "Himanshu Jha", "8888888881"),
            ContactModel(R.drawable.man, "Sudhanshu Jha", "8888888882"),
            ContactModel(R.drawable.male, "Tigmanshu", "8888888883"),
            ContactModel(R.drawable.man, "Rama", "8888888884"),
            ContactModel(R.drawable.doctor, "Raman", "8888888885"),
            ContactModel(R.drawable.hacker, "Ramadhir", "8888888886"),
            ContactModel(R.drawable.male, "Ramanujan", "8888888887"),
            ContactModel(R.drawable.doctor, "Ramesh", "8888888888"),
            ContactModel(R.drawable.woman, "Roma", "8888888889"),
            ContactModel(R.drawable.doctor, "Ramdeen", "8888888880"),
            ContactModel(R.drawable.male, "Rama", "8888888811"),
            ContactModel(R.drawable.man, "Raman", "8888888812"),
            ContactModel(R.drawable.woman, "Kajol", "8888888813"),
            ContactModel(R.drawable.woman, "Preeti", "8888888814"),
            ContactModel(R.drawable.woman, "priya", "8888888815"),
            ContactModel(R.drawable.woman, "Divya", "8888888816"),
            ContactModel(R.drawable.woman, "Priyanka", "8888888817"),
            ContactModel(R.drawable.woman, "Aastha", "8888888818"),
            ContactModel(R.drawable.woman, "Monolisa", "8888888819"),
            ContactModel(R.drawable.woman, "Rani", "8888888820"),
            ContactModel(R.drawable.woman, "Roma", "8888888821"),


            )
        //binding.recyclerViewContact.layoutManager = LinearLayoutManager(this)

        binding.recyclerViewContact.layoutManager = GridLayoutManager(this, 2)
        adapter = RecyclerContactAdapter(this, arrayData)
        binding.recyclerViewContact.adapter = adapter

        // binding.recyclerViewContact.adapter = RecyclerContactAdapter(this, arrayData)


        binding.fabBtn.setOnClickListener {
            Dialog(this).apply {
                var bindingDialog = DialogAddUpdateBinding.inflate(layoutInflater)
                setContentView(bindingDialog.root)
                bindingDialog.btnAdd.setOnClickListener {
                    if (bindingDialog.editName.text.toString() != "" && bindingDialog.editPhone.text.toString() != "") {
                        arrayData.add(
                            ContactModel(
                                R.drawable.man,
                                bindingDialog.editName.text.toString(),
                                bindingDialog.editPhone.text.toString()
                            )
                        )

                        adapter.notifyItemInserted(arrayData.size - 1)
                        dismiss()
                    } else {

                        Toast.makeText(
                            this@MainActivity,
                            "Please fill all the required blanks!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                bindingDialog.btnCancel.setOnClickListener {
                    dismiss()
                }


                show()
            }

        }


    }
}