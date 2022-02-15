package com.gridyushko.purchases.ui.activity

import com.gridyushko.purchases.domain.entities.Product

class MainContract {
    interface View {
        fun setupAdapter()
        fun showProducts(products: List<Product>)
    }

    interface Presenter{
        fun onViewCreated()
        fun fetchPurchases()
    }
}