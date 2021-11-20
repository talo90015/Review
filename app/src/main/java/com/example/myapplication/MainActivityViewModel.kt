package com.example.myapplication

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val bmiResult = MutableLiveData<Float>()
    val weight = MutableLiveData<Float>()
    val height = MutableLiveData<Float>()


    fun theBmi(w: Float, h: Float){
       val bmi = w / (h*h)
        weight.value = w
        height.value = h
        bmiResult.value = bmi
    }

}