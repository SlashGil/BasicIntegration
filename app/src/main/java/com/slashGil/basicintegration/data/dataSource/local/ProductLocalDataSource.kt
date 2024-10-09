package com.slashGil.basicintegration.data.dataSource.local

import com.slashGil.basicintegration.data.dataSource.local.data.ProductDao
import com.slashGil.basicintegration.data.dataSource.local.data.models.ProductEntity
import javax.inject.Inject

class ProductLocalDataSource @Inject constructor(private val productDao: ProductDao) {

    suspend fun insertProducts(products: List<ProductEntity>) = productDao.insertProducts(products)

    suspend fun getProducts(): List<ProductEntity> = productDao.getProducts()
}
