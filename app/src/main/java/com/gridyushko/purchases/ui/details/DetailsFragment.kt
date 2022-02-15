package com.gridyushko.purchases.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.gridyushko.purchases.R
import com.gridyushko.purchases.databinding.DetailsFragmentBinding
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.ui.GlideApp
import com.gridyushko.purchases.ui.buy.BuyFragment

class DetailsFragment: Fragment(R.layout.details_fragment) {

    private val binding: DetailsFragmentBinding by viewBinding()

    private lateinit var product: Product

    var storage = Firebase
        .storage("gs://com-gridyushko-purchases.appspot.com/")
        .reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = arguments?.getParcelable<Product>("product")!!
        Log.i("DetailsFragment", "Created")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            detailsName.text = product.name
            detailsPrice.text = resources.getString(R.string.product_price, product.price)
            detailsDescription.text = product.description
        }
        val storageReference = storage.child(product.key.toString())
        storageReference.downloadUrl.addOnSuccessListener {
            GlideApp.with(binding.detailsPhoto)
                .load(it)
                .fitCenter()
                .into(binding.detailsPhoto)
        }

        binding.BUY.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("product", product)
            val fragment = BuyFragment()
            fragment.arguments = bundle

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(
                R.id.layout,
                fragment
            )
                .commit()
        }
    }
}