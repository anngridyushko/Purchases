package com.gridyushko.purchases.ui.buy

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gridyushko.purchases.R
import com.gridyushko.purchases.databinding.BuyFragmentBinding
import com.gridyushko.purchases.domain.entities.Product

class BuyFragment: Fragment(R.layout.buy_fragment) {

    private val binding: BuyFragmentBinding by viewBinding()

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = arguments?.getParcelable<Product>("product")!!
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.remove(
                        this@BuyFragment
                    )
                        .commit()
                    parentFragmentManager.popBackStack();
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            purchaseName.text = product.name
            purchasePrice.text = resources.getString(R.string.product_price, product.price)
        }
    }

}