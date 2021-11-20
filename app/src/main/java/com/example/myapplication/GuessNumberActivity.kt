package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityGuessNumberBinding
import kotlinx.android.synthetic.main.activity_guess_number.*


class GuessNumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuessNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_number)
        binding = ActivityGuessNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)
            .get(GuessNumberViewModel::class.java)
        viewModel.message.observe(this, {
            binding.txtMassage.text = it
        })
        btnGuess.setOnClickListener {
            viewModel.guess(binding.editNumber.text.toString().toInt())
        }
    }
}