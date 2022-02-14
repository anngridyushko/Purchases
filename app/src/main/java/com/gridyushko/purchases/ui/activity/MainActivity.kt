package com.gridyushko.purchases.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.R
import com.gridyushko.purchases.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    private val binding: ActivityMainBinding by viewBinding()

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewCreated()
    }

    override fun setupAdapter() {
        binding.recyclerView.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun showProducts(products: List<Any>) {
        mainAdapter.submitList(products)
        binding.recyclerView.isVisible = true
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