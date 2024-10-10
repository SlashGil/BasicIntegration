package com.slashGil.basicintegration.data.dataSource

import com.slashGil.basicintegration.MockWebServerRule
import com.slashGil.basicintegration.data.dataSource.data.givenProductsApi
import com.slashGil.basicintegration.data.dataSource.remote.MyApi
import com.slashGil.basicintegration.data.dataSource.remote.ProductRemoteDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals


class ProductRemoteDataSourceShould {

    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    private lateinit var remoteDataSource: ProductRemoteDataSource

    @Before
    fun setUp() {
        remoteDataSource = ProductRemoteDataSource(mockWebServerRule.mockRetrofit().create(MyApi::class.java))
    }

    @Test
    fun `get products from api`() = runTest {
        mockWebServerRule.givenMockResponse(fileName = "responses/products.json")
        val products = givenProductsApi()

        val apiProducts = remoteDataSource.getProducts()

        assertEquals(apiProducts, products)
    }
}