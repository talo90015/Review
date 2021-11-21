package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


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

    fun bmi() {
        val viewModel = ViewModelProvider(this)
            .get(MainActivityViewModel::class.java)
        viewModel.theBmi(
            binding.editWeight.text.toString().toFloat(),
            binding.editHeight.text.toString().toFloat()
        )
        viewModel.bmiResult.observe(this, {
//            binding.txtBmi.text = it.toString()

            val txtBmi = it.toString()

            Intent(this, BmiResultActivity::class.java).apply {
                val bag = Bundle()
                bag.putString("BMI_EXTRA", txtBmi)
                putExtras(bag)
                startActivity(this)
            }

        })

    }

    fun bmiHelpAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("公式")
            .setMessage("體重(kg) / 身高的平方(m)")
            .setPositiveButton("OK", null)
            .show()
    }

}