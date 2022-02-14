package com.gridyushko.purchases.ui.listeners

import com.gridyushko.purchases.domain.entities.Product

interface OnItemClickListener {
    fun onClick(s: Product)
}