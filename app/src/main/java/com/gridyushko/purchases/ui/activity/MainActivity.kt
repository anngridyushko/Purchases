package com.gridyushko.purchases.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding

import com.gridyushko.purchases.databinding.ActivityMainBinding
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.ui.adapters.MainAdapter
import com.gridyushko.purchases.ui.listeners.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

import com.gridyushko.purchases.R
import com.gridyushko.purchases.ui.details.DetailsFragment


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View , OnItemClickListener{

    private val binding: ActivityMainBinding by viewBinding()

    @Inject
    lateinit var presenter: MainContract.Presenter

    var mainAdapter = MainAdapter(this)

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

    override fun showProducts(products: List<Product>) {
        mainAdapter.submitList(products)
        binding.recyclerView.isVisible = true
        Log.i("productslog", products.toString())
    }


    override fun onClick(product: Product) {
        binding.recyclerView.isVisible = false
        val bundle = Bundle()
        bundle.putParcelable("product", product)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction();
            transaction.add(
                R.id.layout,
                fragment
            )
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val count = supportFragmentManager.backStackEntryCount

        if (count == 0) {
            super.onBackPressed()
            binding.recyclerView.isVisible = true
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}