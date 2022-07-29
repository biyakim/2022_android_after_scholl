package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculateResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate_result_activity)

        val num1 = intent.getIntExtra("num1",-1)
        val num2 = intent.getIntExtra("num2",-1)
        val op= intent.getStringExtra("operator")!!
        Log.d("mytag",num1.toString())
        Log.d("mytag",num2.toString())
        Log.d("mytag",op)

        val result = findViewById<TextView>(R.id.result)

        if(op=="+")result.text=(num1+num2).toString()
        else if(op=="-")result.text=(num1-num2).toString()
        else{
            Toast.makeText(this,"잘못된 연산자 입력", Toast.LENGTH_SHORT).show()
            finish()
        }
        val quit = findViewById<Button>(R.id.quit)
        quit.setOnClickListener{
            finish()
        }
    }
}