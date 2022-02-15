package com.gridyushko.purchases.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gridyushko.purchases.databinding.PurchaseItemBinding
import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.ui.GlideApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.gridyushko.purchases.ui.listeners.OnItemClickListener


class MainAdapter constructor(private val clickListener: OnItemClickListener) : ListAdapter<Product, MainAdapter.ItemViewHolder>(
    DiffCallback
) {

    var storage = Firebase
        .storage("gs://com-gridyushko-purchases.appspot.com/")
        .reference

    abstract class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PurchaseItemBinding.inflate(layoutInflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val viewHolder = holder as MainViewHolder
        viewHolder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            clickListener.onClick(getItem(position))
        }

    }

    inner class MainViewHolder(
        private val binding: PurchaseItemBinding
    ) : ItemViewHolder(binding.root) {

        override fun bind(item: Product) {
            val product = item as Product
            val storageReference = storage.child(product.key.toString())

            with(binding) {
                productName.text = product.name
                productPrice.text = "${product.price} $"
            }
            storageReference.downloadUrl.addOnSuccessListener {
                GlideApp.with(binding.productPhoto)
                    .load(it)
                    .into(binding.productPhoto)
            }

        }
    }


    companion object {

        object DiffCallback : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}
