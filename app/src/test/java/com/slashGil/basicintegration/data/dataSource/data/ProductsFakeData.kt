package com.slashGil.basicintegration.data.dataSource.data

import com.slashGil.basicintegration.data.dataSource.remote.models.ProductApi

fun givenProductsApi() = listOf(givenProductApi())

private fun givenProductApi() = ProductApi(
        id = 1,
        name = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        price = 109.95,
        image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
)
