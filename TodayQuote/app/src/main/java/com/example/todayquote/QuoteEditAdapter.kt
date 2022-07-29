package com.example.todayquote

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuoteEditAdapter(val dataList:List<Quote>)
    :RecyclerView.Adapter<QuoteEditAdapter.QuoteItemViewHolder>()
{
        class QuoteItemViewHolder(val view: View):RecyclerView.ViewHolder(view){
            lateinit var  quote: Quote
            val quoteTextEdit = view.findViewById<EditText>(R.id.quote_text_edit)
            val quoteFromEdit = view.findViewById<EditText>(R.id.quote_from_edit)
            val quoteDeleteBtn = view.findViewById<Button>(R.id.quote_delete_btn)
            val quoteModifyBtn = view.findViewById<Button>(R.id.quote_modify_btn)

            init{
                val pref=view.context.getSharedPreferences("quotes",Context.MODE_PRIVATE)

                quoteDeleteBtn.setOnClickListener{
                    Toast.makeText(it.context,"삭제되었습니다.",Toast.LENGTH_SHORT).show()

                    quoteTextEdit.setText("")
                    quoteFromEdit.setText("")

                    Quote.removeQuoteFromPreference(pref,adapterPosition)
                }
                quoteModifyBtn.setOnClickListener{
                    Toast.makeText(it.context,"수정되었습니다",Toast.LENGTH_SHORT)

                    val  newQuoteText = quoteTextEdit.text.toString()
                    val newQuoteFrom=quoteFromEdit.text.toString()

                    Quote.saveToPreference(pref,adapterPosition,newQuoteText)

                    quote.text = newQuoteText
                    quote.from=newQuoteFrom
                }
            }

            fun bind(q:Quote){
                quote=q
                quoteTextEdit.setText(quote.text)
                quoteFromEdit.setText(quote.from)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent,false)
        return QuoteEditAdapter.QuoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteItemViewHolder, position: Int) {
        Log.d("mytag",position.toString())
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.quote_edit_list_item
    }
}