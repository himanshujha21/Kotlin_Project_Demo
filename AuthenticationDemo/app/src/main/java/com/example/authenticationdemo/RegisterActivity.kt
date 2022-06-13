package com.example.authenticationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import com.example.authenticationdemo.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


    }

    private fun validatePasswordAndConfrirmPassword(): Boolean {
        var error: String? = null
        val password = binding.editPassword.text.toString()
        val confirmPassword = binding.editConfirmPassword.text.toString()
        if (password != confirmPassword) {
            error = "Confirm Password is doesn't match with Password"
        }

        return error == null
    }

    private fun validateConfirmPassword(): Boolean {
        var error: String? = null
        val confirmPassword: String = binding.editConfirmPassword.text.toString()
        if (confirmPassword.isEmpty()) {

            error = " Confirm Password is required"

        } else if (confirmPassword.length < 6) {
            error = " Confirm Password must be 6 character long!"

        }

        return error == null

    }

    private fun validatePassword(): Boolean {
        var error: String? = null
        val password: String = binding.editPassword.text.toString()
        if (password.isEmpty()) {

            error = "Email is required"

        } else if (password.length < 6) {
            error = "Password must be 6 character long!"

        }

        return error == null

    }

    private fun validateEmail(): Boolean {
        var error: String? = null
        val email: String = binding.editEmail.text.toString()
        if (email.isEmpty()) {

            error = "Email is required"

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error = "Email address is invalid!"

        }

        return error == null


    }

    private fun validateFullName(): Boolean {
        var error: String? = null
        val fullName: String = binding.editFullName.text.toString()
        if (fullName.isEmpty()) {
            error = " full name is required"
        }

        return error == null

    }


    override fun onClick(p0: View?) {

    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }
}