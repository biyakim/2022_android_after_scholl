package com.example.lotteryapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LotteryNumListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottery_num_list)
        val pref = getSharedPreferences("nums", Context.MODE_PRIVATE)
        var lottoNums :String? = pref.getString("lottonums","")
        var numList = if(lottoNums == ""){
            mutableListOf<String>()
        }else{
            lottoNums!!.split(",").toMutableList()
        }
        val listView = findViewById<RecyclerView>(R.id.num_list)
        listView.setHasFixedSize(true)
        listView.layoutManager = LinearLayoutManager(this)

        listView.adapter = LotteryListAdapter(numList)

        listView.setHasFixedSize(true)
    }
}