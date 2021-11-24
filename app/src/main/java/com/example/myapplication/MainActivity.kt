package com.example.myapplication

import android.app.Activity
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
    companion object {
        const val loginValue = 1000
    }

    private var login = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity ", "onCreate")
        if (!login) {
            Intent(this, LoginActivity::class.java).apply {
                startActivityForResult(this, loginValue)
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBMI.setOnClickListener {
            bmi()
        }
        binding.btnHelp.setOnClickListener {
            bmiHelpAlertDialog()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivity ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity ", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity ", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity ", "onDestroy")
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