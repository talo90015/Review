package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GuessNumberViewModel: ViewModel() {
    val message = MutableLiveData<String>()
    private var secret = Random.nextInt(10) + 1

    fun guess(num: Int){
        val text = when(num - secret){
            0 -> "答對了"
            in 1..10 -> "小一點"
            else -> "大一點"
        }
        message.value = text
    }
}