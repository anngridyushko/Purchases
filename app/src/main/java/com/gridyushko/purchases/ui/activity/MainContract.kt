package com.gridyushko.purchases.ui.activity

import com.gridyushko.purchases.domain.entities.Product

class MainContract {
    interface View {
        fun setupAdapter()
        fun showProducts(list: List<Product>)
        fun showProgressBar()
        fun hideProgressBar()
        fun showError()
        fun hideError()
    }

    interface Presenter{
        fun onViewCreated()
        fun fetchPurchases()
    }
}