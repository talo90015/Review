package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            login()
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }
    fun login(){
        val youAccount = binding.editAccount.text.toString()
        val youPassword = binding.editPassword.text.toString()
        if (youAccount == "a" && youPassword == "123"){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            intent.putExtra("Login_Account", youAccount)
            intent.putExtra("Login_Password", youPassword)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }else{
            AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Login Failed")
                .setPositiveButton("OK", null)
                .show()
        }
    }
    fun cancel(){

    }
}