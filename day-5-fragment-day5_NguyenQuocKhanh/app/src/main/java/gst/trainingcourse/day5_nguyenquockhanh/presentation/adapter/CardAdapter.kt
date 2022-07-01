package gst.trainingcourse.day5_nguyenquockhanh.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.day5_nguyenquockhanh.databinding.ItemCardBinding
import gst.trainingcourse.day5_nguyenquockhanh.domain.entity.Card

class CardAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val onClick: (card: Card, position: Int) -> Unit
) : ListAdapter<Card, CardAdapter.CardViewHolder>(CardDiffUtil()) {
    inner class CardViewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card, position: Int) {
            binding.name = card.name
            binding.lifecycleOwner = lifecycleOwner
            binding.root.setOnClickListener { onClick(card, position) }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card, position)
    }
}