package com.slashGil.basicintegration.data.dataSource.remote

import com.slashGil.basicintegration.data.dataSource.remote.models.ProductApi
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(private val myApi: MyApi) {

    suspend fun getProducts(): List<ProductApi> = myApi.getProducts()
}
