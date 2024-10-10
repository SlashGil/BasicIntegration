package com.slashGil.basicintegration.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.slashGil.basicintegration.databinding.ProductItemBinding
import com.slashGil.basicintegration.presentation.adapter.viewHolder.ProductViewHolder
import com.slashGil.basicintegration.presentation.data.ProductUi

class ProductsAdapter() : RecyclerView.Adapter<ProductViewHolder>() {
    private var products: List<ProductUi> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount() = products.size

    fun setProducts(products: List<ProductUi>) {
        this.products = products
        notifyDataSetChanged()
    }
}