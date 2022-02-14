package com.gridyushko.purchases.data.repositories

import com.gridyushko.purchases.data.db.ProductsDB
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val db: ProductsDB): ProductsRepository {

    override fun getProducts(): List<Product> {
        return db.getPurchases()
    }

}
