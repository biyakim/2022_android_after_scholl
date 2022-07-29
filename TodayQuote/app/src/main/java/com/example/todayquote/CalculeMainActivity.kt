package com.example.todayquote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CalculeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcule_main_activity)

        val num1=findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val operator = findViewById<EditText>(R.id.operator)
        val calcBtn = findViewById<Button>(R.id.calc_btn)

        calcBtn.setOnClickListener{
            Log.d("mytag",num1.text.toString())
            Log.d("mytag",num2.text.toString())
            Log.d("mytag",operator.text.toString())

            val bad = Integer.parseInt(num1.text.toString())
            val n1=num1.text.toString().toInt()
            val n2=num2.text.toString().toInt()

            val intent = Intent(this,CalculateResultActivity::class.java)
            intent.putExtra("num1",n1)
            intent.putExtra("num2",n2)
            intent.putExtra("operator",operator.text.toString())
            startActivity(intent)
        }


    }
}