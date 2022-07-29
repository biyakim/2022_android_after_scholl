package com.example.lotteryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class LotteryListAdapter (val dataList: List<String>)
    : RecyclerView.Adapter<LotteryListAdapter.ItemViewHolder>()
{
        class ItemViewHolder(val view: View)
            : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.num).text= dataList[position]
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.lotto_item
    }
}