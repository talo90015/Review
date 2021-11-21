package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityBmiResultBinding

class BmiResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)
        binding = ActivityBmiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val bmi = intent.getStringExtra("BMI_EXTRA")

        val bundle = intent.extras
        val bmi = bundle?.getString("BMI_EXTRA")
        binding.txtIntentResult.text = bmi
    }
}