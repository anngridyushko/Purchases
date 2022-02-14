package com.gridyushko.purchases.ui.activity

class MainContract {
    interface View {
        fun setUpNavigation()
    }

    interface Presenter{
        fun onCreate()
    }
}