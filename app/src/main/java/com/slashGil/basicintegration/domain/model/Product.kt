package com.slashGil.basicintegration.domain.model

import com.slashGil.basicintegration.data.dataSource.local.data.models.ProductEntity

data class Product(val name: String,
                   val price: Double)

fun List<Product>.toProductEntities(): List<ProductEntity> = map { it.toProductEntity() }

private fun Product.toProductEntity(): ProductEntity = ProductEntity(name = name, price = price)
