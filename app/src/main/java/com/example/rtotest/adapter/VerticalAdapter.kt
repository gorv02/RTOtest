package com.example.rtotest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rtotest.R
import com.example.rtotest.model.Question

class VerticalAdapter (private val list : List<Question>, private val onClick : ClickListener) :
    RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>() {

    inner class VerticalViewHolder(val view: View):
        RecyclerView.ViewHolder(view){
            fun bindData(data : Question, QNo : Int){
                val que = view.findViewById<TextView>(R.id.que)
                val ans = view.findViewById<TextView>(R.id.ans)

                que.text = "$QNo. ${data.que}"
                ans.text = "Ans: ${data.ans}"

                view.setOnClickListener{
                    onClick.onClickRvVertical(data, QNo)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent,false)

        return VerticalViewHolder(v)
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bindData(list[position], position+1)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ClickListener{
        fun onClickRvVertical(data : Question, QNo : Int)
    }
}