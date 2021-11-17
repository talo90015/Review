package com.example.lib

fun main(){
    val person = Person()
    person.weight = 44f
    person.height = 1.7f
    print("${person.bmi()}")
}

class Person {
    var weight: Float = 0f
    var height: Float = 0f

    fun bmi(): Float{
        val theBmi = weight / (height * height)
        return theBmi
    }
}