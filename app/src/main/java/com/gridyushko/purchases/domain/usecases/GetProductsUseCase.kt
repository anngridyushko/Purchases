package com.gridyushko.purchases.domain.usecases

import com.gridyushko.purchases.domain.repositories.ProductsRepository

class GetProductsUseCase(private val repo: ProductsRepository) {

    operator fun invoke() = repo.getProducts()
}