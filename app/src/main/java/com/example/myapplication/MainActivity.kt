package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBMI.setOnClickListener {
            bmi()
        }
        binding.btnHelp.setOnClickListener {
            bmiHelpAlertDialog()
        }
    }
    fun bmi(){
        val weight = binding.editWeight.text.toString().toFloat()
        val height = binding.editHeight.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("result", bmi.toString())

        AlertDialog.Builder(this)
            .setMessage(bmi.toString())
            .setTitle("BMI is : ")
            .setPositiveButton("OK", null)
            .show()
    }
    fun bmiHelpAlertDialog(){
        AlertDialog.Builder(this)
            .setTitle("公式")
            .setMessage("體重(kg) / 身高的平方(m)")
            .setPositiveButton("OK", null)
            .show()
    }

}