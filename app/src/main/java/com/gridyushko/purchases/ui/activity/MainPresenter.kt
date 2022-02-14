package com.gridyushko.purchases.ui.activity

import com.gridyushko.purchases.domain.usecases.GetProductsUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val getProductsUseCase: GetProductsUseCase)
    : MainContract.Presenter {
    override fun onViewCreated() {
        TODO("Not yet implemented")
    }

}