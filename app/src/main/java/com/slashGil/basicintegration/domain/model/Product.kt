package com.slashGil.basicintegration.domain.model

import com.slashGil.basicintegration.data.dataSource.local.data.models.ProductEntity

data class Product(val id: Int,
                   val name: String,
                   val price: Double,
                   val image:String)

fun List<Product>.toProductEntities(): List<ProductEntity> = map { it.toProductEntity() }

private fun Product.toProductEntity(): ProductEntity = ProductEntity(id = id, name = name, price = price, image = image)
