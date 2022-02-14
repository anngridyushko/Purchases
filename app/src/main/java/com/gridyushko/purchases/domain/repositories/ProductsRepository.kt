package com.gridyushko.purchases.domain.repositories

import com.gridyushko.purchases.domain.entities.Product

interface ProductsRepository {
    fun getProducts(): List<Product>
}