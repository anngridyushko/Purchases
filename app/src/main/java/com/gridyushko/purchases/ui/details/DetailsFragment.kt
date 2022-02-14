package com.gridyushko.purchases.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.gridyushko.purchases.R

class DetailsFragment: Fragment(R.layout.details_fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DetailsFragment", "Created")
    }
}