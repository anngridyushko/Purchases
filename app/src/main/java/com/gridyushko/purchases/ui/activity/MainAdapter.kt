package com.gridyushko.purchases.ui.activity

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.gridyushko.purchases.databinding.PurchaseItemBinding
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.ui.GlideApp
import javax.inject.Inject
import com.google.android.gms.tasks.OnSuccessListener




class MainAdapter @Inject constructor() : ListAdapter<Any, MainAdapter.ItemViewHolder>(DiffCallback) {

    @Inject
    lateinit var storage: StorageReference

    abstract class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Any)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PurchaseItemBinding.inflate(layoutInflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val viewHolder = holder as MainViewHolder
        viewHolder.bind(getItem(position))

    }

    inner class MainViewHolder(
        private val binding: PurchaseItemBinding
    ) : ItemViewHolder(binding.root) {

        override fun bind(item: Any) {
            val product = item as Product
            val storageReference = storage.child(product.key.toString())

            with(binding) {
                productName.text = product.name
                productPrice.text = product.price.toString()
            }
            storageReference.downloadUrl.addOnSuccessListener(OnSuccessListener<Any?> {
                GlideApp.with(binding.productPhoto)
                    .load(it)
                    .into(binding.productPhoto)
            })

        }
    }


    companion object {

        object DiffCallback : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                if (oldItem is Product && newItem is Product)
                    return oldItem.name == newItem.name
                return false
            }

            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                return if (oldItem is String && newItem is String)
                    oldItem.hashCode() == newItem.hashCode()
                else if (oldItem is Product && newItem is Product)
                    oldItem.hashCode() == newItem.hashCode()
                else false
            }
        }
    }
}
