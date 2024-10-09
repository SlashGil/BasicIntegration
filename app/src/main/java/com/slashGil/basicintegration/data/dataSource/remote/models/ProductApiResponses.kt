package com.slashGil.basicintegration.data.dataSource.remote.models

import com.slashGil.basicintegration.domain.model.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductApi(
        @SerialName("name")
        val name: String,
        @SerialName("price")
        val price: Double)


fun List<ProductApi>.toProducts(): List<Product> = map { it.toProduct() }

private fun ProductApi.toProduct(): Product = Product(name, price)