package com.slashGil.basicintegration.data.dataSource.local.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slashGil.basicintegration.domain.model.Product

@Entity(tableName = "products")
data class ProductEntity(@PrimaryKey(autoGenerate = true)
                   val id: Int = 0,
                   val name: String,
                   val price: Double)

fun List<ProductEntity>.toProducts(): List<Product> = map { it.toProduct() }

private fun ProductEntity.toProduct(): Product = Product(name, price)