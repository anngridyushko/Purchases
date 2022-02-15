package com.gridyushko.purchases.ui.activity

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.gridyushko.purchases.domain.entities.Product
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View)
    : MainContract.Presenter {

    @Inject
    lateinit var db: DatabaseReference

    override fun onViewCreated() {
        view.setupAdapter()
        fetchPurchases()
    }

    override fun fetchPurchases() {
        val product: MutableList<Product> = arrayListOf()

        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                product.clear()
                for (postSnapshot in snapshot.child("Products").children) {
                    val pr = postSnapshot.getValue(Product::class.java)!!
                    pr.key = postSnapshot.key + ".jpg"
                    product.add(pr)
                }

                view.showProducts(product)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                System.out.println("The read failed: " + databaseError.getMessage())
            }
        })
    }



}