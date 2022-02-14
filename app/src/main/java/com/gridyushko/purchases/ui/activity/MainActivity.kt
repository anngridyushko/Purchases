package com.gridyushko.purchases.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewCreated()
    }

    override fun setupAdapter() {
        TODO("Not yet implemented")
    }

    override fun showProducts(products: List<Any>) {
        Log.i("productslog", products.toString())
    }

    override fun showProgressBar() {
        TODO("Not yet implemented")
    }

    override fun hideProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun hideError() {
        TODO("Not yet implemented")
    }
}