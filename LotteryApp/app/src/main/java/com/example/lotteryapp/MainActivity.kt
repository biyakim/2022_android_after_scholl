package com.example.lotteryapp

import android.content.Context
import android.content.Intent
import android.icu.text.StringPrepParseException
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var currentNums:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("nums", Context.MODE_PRIVATE)

        val lottoNumView = findViewById<TextView>(R.id.lotto_num)
        currentNums = generateRandomLottoNum(6, "-")
        lottoNumView.text = currentNums
        val generateNumberBtn = findViewById<Button>(R.id.gen_num)
        generateNumberBtn.setOnClickListener {
            currentNums = generateRandomLottoNum(6, "-")
            lottoNumView.text = currentNums
        }
        val saveNumberBtn = findViewById<Button>(R.id.save_num)
        saveNumberBtn.setOnClickListener{
            var lottoNums :String? = pref.getString("lottonums","")
            var numList = if(lottoNums == ""){
                mutableListOf<String>()
            }else{
                lottoNums!!.split(",").toMutableList()
            }
            numList.add(currentNums)
            Log.d("mytag",numList.toString())
            Log.d("mytag",numList.toString())

            val editor=pref.edit()
            editor.putString("lottonums",numList.joinToString(","))
            editor.apply()

        }
        findViewById<Button>(R.id.num_list).setOnClickListener{
            val intent=Intent(this,LotteryNumListActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.check_num).setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW,
                Uri.parse("https://m.dhlottery.co.kr/gameResult.do?method=byWin&wiselog=M_A_1_8"))
            startActivity(intent)
        }
    }

    fun generateRandomLottoNum(count: Int, sep: String = "-"): String {
        val nums = mutableListOf<Int>()
        for (i in 1..count) nums.add((1..45).random())
        return nums.joinToString(sep)
    }
}