package com.gridyushko.purchases.data.repositories

import com.gridyushko.purchases.data.db.ProductsDB
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.domain.repositories.ProductsRepository

class ProductsRepositoryImpl(private val db: ProductsDB): ProductsRepository {
    override fun getProducts(): List<Product> {
        TODO("Not yet implemented")
    }

}
