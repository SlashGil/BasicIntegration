package com.slashGil.basicintegration.presentation.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.slashGil.basicintegration.presentation.adapter.ProductsAdapter
import com.slashGil.basicintegration.presentation.data.ProductUiModel

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, items: LiveData<ProductUiModel>?) {
    items?.observe(recyclerView.context as LifecycleOwner, Observer { products ->
        (recyclerView.adapter as? ProductsAdapter)?.submitList(products.products) ?: run {
            recyclerView.adapter = ProductsAdapter(products.products)
        }
    })
}

@BindingAdapter("app:isVisible")
fun View.isVisible(isVisible: LiveData<ProductUiModel>) {
    isVisible.observe(this.context as LifecycleOwner, Observer {
        this.visibility = if (it.isLoading) View.VISIBLE else View.GONE
    })
}

@BindingAdapter("app:imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        this.load(url) {
            crossfade(true)
        }
    }
}