package gst.trainingcourse.day5_nguyenquockhanh.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import gst.trainingcourse.day5_nguyenquockhanh.domain.entity.Card

class CardDiffUtil : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
        oldItem.cardNumber == newItem.cardNumber

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
        oldItem == newItem
}