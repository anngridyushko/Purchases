package com.gridyushko.purchases.di

import com.gridyushko.purchases.domain.entities.Product
import com.gridyushko.purchases.ui.activity.MainContract
import com.gridyushko.purchases.ui.activity.MainPresenter
import com.gridyushko.purchases.ui.adapters.MainAdapter
import com.gridyushko.purchases.ui.listeners.OnItemClickListener
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AdapterModule {

}