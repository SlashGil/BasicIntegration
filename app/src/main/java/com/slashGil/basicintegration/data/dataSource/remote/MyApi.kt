package com.slashGil.basicintegration.data.dataSource.remote

import com.slashGil.basicintegration.data.dataSource.remote.models.ProductApi
import retrofit2.http.GET

interface MyApi {
    @GET("products")
        suspend fun getProducts(): List<ProductApi>
}