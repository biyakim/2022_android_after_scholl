package com.example.todayquote

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuoteListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_list)

        val size = intent.getIntExtra("quote_size",-1)
        Log.d("mytag",size.toString())

        val pref = getSharedPreferences("quotes", Context.MODE_PRIVATE)
        //1)
        val quotes = Quote.getQuotesFromPreference(pref)

        val layoutManager = LinearLayoutManager(this)

        val quoteList = findViewById<RecyclerView>(R.id.quote_list)

        val adapter=QuoteAdapter(quotes)
        quoteList.setHasFixedSize(false)
        quoteList.layoutManager=layoutManager
        quoteList.adapter=adapter
    }
}