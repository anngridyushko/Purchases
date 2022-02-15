package com.gridyushko.purchases.domain.entities

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var key: String? = "",
    val name: String? = "",
    val description: String? = "",
    val price: Double? = 0.0
): Parcelable