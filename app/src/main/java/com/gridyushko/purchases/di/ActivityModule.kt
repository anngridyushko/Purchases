package com.gridyushko.purchases.di

import com.gridyushko.purchases.ui.activity.MainActivity
import com.gridyushko.purchases.ui.activity.MainContract
import com.gridyushko.purchases.ui.activity.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class ActivityModule {

    @Binds
    abstract fun bindActivity(activity: MainActivity): MainContract.View

    @Binds
    abstract fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter
}