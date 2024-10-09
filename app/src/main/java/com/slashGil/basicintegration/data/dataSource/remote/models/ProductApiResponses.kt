package com.slashGil.basicintegration.data.dataSource.remote.models

import com.slashGil.basicintegration.domain.model.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductApi(
        @SerialName("title")
        val name: String,
        val price: Double,
        val image: String)


fun List<ProductApi>.toProducts(): List<Product> = map { it.toProduct() }

private fun ProductApi.toProduct(): Product = Product(name, price,image)