package com.gridyushko.purchases.data.db

import android.content.Context
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.gridyushko.purchases.domain.entities.Product
import kotlinx.coroutines.CoroutineScope
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
                for (postSnapshot in snapshot.children) {
                    val prod: Product? = postSnapshot.child("Products").getValue(Product::class.java)
                    product.add(prod!!)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                System.out.println("The read failed: " + databaseError.getMessage())
            }
        })
        return product
    }
}