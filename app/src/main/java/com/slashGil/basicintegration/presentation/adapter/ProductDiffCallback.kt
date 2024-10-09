package com.slashGil.basicintegration.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.slashGil.basicintegration.presentation.data.ProductUi

class ProductDiffCallback : DiffUtil.ItemCallback<ProductUi>() {
    override fun areItemsTheSame(oldItem: ProductUi, newItem: ProductUi): Boolean {
        return oldItem.name == newItem.name && oldItem.image == newItem.image && oldItem.price == newItem.price
    }

    override fun areContentsTheSame(oldItem: ProductUi, newItem: ProductUi): Boolean {
        return oldItem == newItem
    }
}