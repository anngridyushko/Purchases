package com.gridyushko.purchases.ui.activity

class MainContract {
    interface View {
        fun setupAdapter()
        fun showProducts(list: List<Any>)
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