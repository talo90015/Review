package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMaterialBinding

class MaterialActivity : AppCompatActivity() {
    companion object {
        const val loginValue = 1000
    }
    private lateinit var binding: ActivityMaterialBinding
    private var login = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!login) {
            Intent(this, LoginActivity::class.java).apply {
                startActivityForResult(this, loginValue)
            }
        }


        setSupportActionBar(binding.toolbar)



        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "String", Snackbar.LENGTH_LONG)
                .setAction("Action"){
                    Log.d("Press", "Press the button")
                }
                .setActionTextColor(Color.GREEN)
                .show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == loginValue) {
            if (resultCode == Activity.RESULT_OK) {
                val youAccount = data?.getStringExtra("Login_Account")
                val youPassword = data?.getStringExtra("Login_Password")
                Log.d("Result", "$youAccount / $youPassword")
            }
        }
    }
}