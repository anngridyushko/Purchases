package com.gridyushko.purchases.ui

import com.firebase.ui.storage.images.FirebaseImageLoader

import com.google.firebase.storage.StorageReference

import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule

import com.bumptech.glide.module.AppGlideModule
import com.google.firebase.database.core.Context
import java.io.InputStream

@GlideModule
class GlideModule : AppGlideModule() {
    fun registerComponents(context: Context?, registry: Registry) {
        registry.append(
            StorageReference::class.java, InputStream::class.java,
            FirebaseImageLoader.Factory()
        )
    }
}