package com.nguyenvancuong.day5_fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguyenvancuong.day5_fragment.R
import com.nguyenvancuong.day5_fragment.models.Card
import kotlinx.android.synthetic.main.card_row_item.view.*

class CardAdapter(private val listCard:MutableList<Card>, var onClick:(card:Card, position:Int)->Unit): RecyclerView.Adapter<CardAdapter.CardHolder>() {
    inner class CardHolder(view:View):RecyclerView.ViewHolder(view){
        fun onBind(card:Card, position: Int){
            itemView.tv_name.text = card.cardName
            itemView.setOnClickListener {
                onClick(card, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_row_item,parent,false))
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.onBind(listCard[position],position)
    }

    override fun getItemCount(): Int {
        return listCard.size
    }
}