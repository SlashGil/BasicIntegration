package com.slashGil.basicintegration.data.repository

import com.slashGil.basicintegration.core.Result
import com.slashGil.basicintegration.data.dataSource.local.ProductLocalDataSource
import com.slashGil.basicintegration.data.dataSource.local.data.models.toProducts
import com.slashGil.basicintegration.data.dataSource.remote.ProductRemoteDataSource
import com.slashGil.basicintegration.data.dataSource.remote.models.toProducts
import javax.inject.Inject
import com.slashGil.basicintegration.domain.model.Product
import com.slashGil.basicintegration.domain.model.toProductEntities

class ProductRepository @Inject constructor(private val remoteDataSource: ProductRemoteDataSource,
                                            private val localDataSource: ProductLocalDataSource) {
    suspend fun getProducts(): Result<List<Product>> {
        return try {
            val remoteProducts = remoteDataSource.getProducts()
            val products = remoteProducts.toProducts()
            localDataSource.insertProducts(products.toProductEntities())
            val localProducts = localDataSource.getProducts().toProducts()
            Result.Success(localProducts)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}