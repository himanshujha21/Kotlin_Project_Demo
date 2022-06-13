package com.example.implicitcallssample

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.implicitcallssample.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        binding.btnDial.setOnClickListener {

            checkPermission()
            callPhone()

            /*val uriNumber = Uri.parse("tel:09559284273")
            val iDial = Intent(Intent.ACTION_CALL, uriNumber)
            startActivity(iDial)
*/
        }

        binding.btnEmail.setOnClickListener {

//when multiple things related to object then we use scope function apply
            val emailIntent = Intent().apply {
                action = Intent.ACTION_SEND

                type = "text/plain"//type take as static

                putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf("jhahimanshu0032@gmail.com", "sudhanshujha21@gmail.com")
                )
                putExtra(Intent.EXTRA_SUBJECT, "Heading Here!")
                putExtra(Intent.EXTRA_TEXT, "Message here")

            }//end of scope function

            startActivity(emailIntent)



            binding.btnMessage.setOnClickListener {

                val msgIntent = Intent().apply {
                    action = Intent.ACTION_VIEW

                    data = Uri.parse("sms:8882535973")
                    putExtra("sms_body", "Message here!")
                }

                startActivity(msgIntent)

            }

            binding.btnShare.setOnClickListener {
                val iShare = Intent().apply {
                    action = Intent.ACTION_SEND

                    type = "text/plain"

                    putExtra(Intent.EXTRA_TEXT, "Sharing message here!")


                }

                startActivity(
                    Intent.createChooser(
                        iShare,
                        "Share Via"
                    )
                )//shareing from multiple platform
            }

        }


    }


    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.CALL_PHONE
                )
            ) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    42
                )
            }
        } else {
            // Permission has already been granted
            callPhone()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 42) {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay!
                callPhone()
            } else {
                // permission denied, boo! Disable the
                // functionality
            }
            return
        }
    }

    fun callPhone() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9559284273"))
        startActivity(intent)
    }
//And don't forget you also need it on the manifest. And you can remove that exported from your activity, that's pointless.

}
