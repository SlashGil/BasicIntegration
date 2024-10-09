package com.slashGil.basicintegration.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.slashGil.basicintegration.databinding.ProductItemBinding
import com.slashGil.basicintegration.presentation.adapter.viewHolder.ProductViewHolder
import com.slashGil.basicintegration.presentation.data.ProductUi

class ProductsAdapter(private val products: List<ProductUi>) : ListAdapter<ProductUi, ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = products.size
}