package com.gridyushko.purchases.di

import android.app.Application
import android.content.Context
import com.gridyushko.purchases.ui.adapters.MainAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Singleton
    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideAdapter(): MainAdapter = MainAdapter()
}