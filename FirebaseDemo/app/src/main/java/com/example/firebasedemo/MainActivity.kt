package com.example.firebasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    companion object {
        val USER_COLLECTION = "user_info"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //FireStore Data Write
        val mFirestore = FirebaseFirestore.getInstance()
        mFirestore.collection(USER_COLLECTION)
            .document("Sudhanshu Jha")

            .set(User("Sudhanshu Jha", "Mohan Jha", "1234567890", "Bihar"))
            .addOnSuccessListener {
                Log.d("Data", "Successfully user data Inserted!")

            }

            .addOnFailureListener {
                Log.e("Data", it.toString())


            }

        //FireStore Data Fetch
        mFirestore.collection(USER_COLLECTION)
            .get()
            .addOnSuccessListener {

                // Log.d("Documents", it.documents.toString())

                for (document in it.documents) {
                    val userModel = document.toObject(User::class.java)
                    userModel!!.let {
                        Log.d(
                            "UserDetails",
                            "Name:${userModel.name}, LName:${userModel.FatherName},Mob:${userModel.mobNo},Address:${userModel.address}"
                        )

                    }


                }

            }


    }
}