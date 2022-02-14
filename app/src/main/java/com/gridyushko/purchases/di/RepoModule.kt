package com.gridyushko.purchases.di

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
object RepoModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(db: ProductsDB): ProductsRepository = ProductsRepositoryImpl(db)
}