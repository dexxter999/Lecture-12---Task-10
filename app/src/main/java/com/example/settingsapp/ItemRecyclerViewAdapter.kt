package com.example.settingsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.settingsapp.databinding.ItemLayoutBinding

class ItemRecyclerViewAdapter() :
    ListAdapter<Item, ItemRecyclerViewAdapter.ItemViewHolder>(ItemDiffCallback()) {

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.apply {
                ivIcon.setImageResource(item.icon)

                tvTitle.text = item.title
                val textColor = if (item.textColor) {
                    ContextCompat.getColor(binding.root.context, R.color.red)
                } else {
                    ContextCompat.getColor(binding.root.context, R.color.white)
                }
                binding.tvTitle.setTextColor(textColor)


                tvLanguage.text?.let {
                    tvLanguage.visibility = View.VISIBLE
                    tvLanguage.text = item.moreInfo
                } ?: run {
                    tvLanguage.visibility = View.GONE
                }

                if (item.hasSwitch) {
                    switchOn.visibility = View.VISIBLE
                    switchOn.isChecked = false
                } else {
                    switchOn.visibility = View.GONE
                }

                ivArrow.visibility = if (item.iconArrow != Item.ARROW) View.VISIBLE else View.GONE
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}