package com.gridyushko.purchases.ui.activity

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.gridyushko.purchases.data.db.ProductsDB
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.domain.usecases.GetProductsUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val getProductsUseCase: GetProductsUseCase,
    private val db: ProductsDB)
    : MainContract.Presenter {

    override fun onViewCreated() {
        view.setupAdapter()
        fetchPurchases()
    }

    override fun fetchPurchases() {

        var product: MutableList<Product> = arrayListOf()
        db.database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                product.clear()
                for (postSnapshot in snapshot.child("Products").children) {
                    product.add(postSnapshot.getValue(Product::class.java)!!)
                }
                view.showProducts(product)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                System.out.println("The read failed: " + databaseError.getMessage())
            }
        })
    }


}