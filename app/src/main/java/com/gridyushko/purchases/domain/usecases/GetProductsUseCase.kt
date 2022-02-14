package com.gridyushko.purchases.domain.usecases

import com.gridyushko.purchases.domain.repositories.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repo: ProductsRepository) {

    operator fun invoke() = repo.getProducts()
}