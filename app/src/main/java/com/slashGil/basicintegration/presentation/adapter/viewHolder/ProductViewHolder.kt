package com.slashGil.basicintegration.presentation.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.slashGil.basicintegration.databinding.ProductItemBinding
import com.slashGil.basicintegration.presentation.data.ProductUi

class ProductViewHolder(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(product: ProductUi) {
        binding.product = product
        binding.executePendingBindings()
    }
}