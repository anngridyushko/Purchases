package com.gridyushko.purchases.data.db

import com.google.firebase.database.DatabaseReference
import com.gridyushko.purchases.domain.entities.Product
import javax.inject.Inject
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
class ProductsDB @Inject constructor() {

    @Inject
    lateinit var database: DatabaseReference

    fun getPurchases(): List<Product> {
        var product: MutableList<Product> = arrayListOf()
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                product.clear()
                for (postSnapshot in snapshot.child("Products").children) {
                    product.add(postSnapshot.getValue(Product::class.java)!!)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                System.out.println("The read failed: " + databaseError.getMessage())
            }
        })

        return product.toList()
    }

}