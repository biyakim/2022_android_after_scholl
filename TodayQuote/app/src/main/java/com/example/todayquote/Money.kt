package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Money : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)

        var nums = findViewById<TextView>(R.id.lotto_nums)

        var lottoNums = mutableListOf<Int>()
        for (i in 1..6) lottoNums.add((1..45).random())
        nums.text = "${lottoNums[0]}-${lottoNums[1]}-${lottoNums[3]}-${lottoNums[4]}-${lottoNums[5]}"
    }
}