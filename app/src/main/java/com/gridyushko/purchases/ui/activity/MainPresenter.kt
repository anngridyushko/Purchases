package com.gridyushko.purchases.ui.activity

import javax.inject.Inject

class MainPresenter @Inject constructor(private val view: MainContract.View)
    : MainContract.Presenter {

    override fun onCreate() {
        view.setUpNavigation()
    }
}