package com.slashGil.basicintegration.domain.useCase

import com.slashGil.basicintegration.data.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke() = productRepository.getProducts()
}
