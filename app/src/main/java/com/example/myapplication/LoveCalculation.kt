package com.example.myapplication

class LoveCalculation {
    fun calculateLove(name1: String, name2: String): Int {
        val sum = name1.sumBy { it.toInt() } + name2.sumBy { it.toInt() }
        return (sum % 101)
    }
}
