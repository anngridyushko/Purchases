package com.gridyushko.purchases.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.R

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database("https://com-gridyushko-purchases-default-rtdb.europe-west1.firebasedatabase.app/").reference
        database.child("Products").child("Test").setValue(Product("test", "test", 2.1))

        database.child("Products").get().addOnSuccessListener {
            Log.i("firebaselog", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebaselog", "Error getting data", it)
        }
    }
}