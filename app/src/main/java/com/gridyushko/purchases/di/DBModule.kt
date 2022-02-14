package com.gridyushko.purchases.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.gridyushko.purchases.data.db.ProductsDB
import com.gridyushko.purchases.data.repositories.ProductsRepositoryImpl
import com.gridyushko.purchases.domain.repositories.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDB(): DatabaseReference {
        return Firebase
            .database("https://com-gridyushko-purchases-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
    }
}