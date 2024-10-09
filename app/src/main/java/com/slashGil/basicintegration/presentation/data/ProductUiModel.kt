package com.slashGil.basicintegration.presentation.data

import com.slashGil.basicintegration.domain.model.Product

data class ProductUi(val name: String, val price: Double)

data class ProductUiModel(val isLoading: Boolean, val products: List<ProductUi>, val exception: Exception?)

fun List<Product>.toProductUi(): List<ProductUi> = map { it.toProductUi() }

private fun Product.toProductUi(): ProductUi = ProductUi(name, price)
