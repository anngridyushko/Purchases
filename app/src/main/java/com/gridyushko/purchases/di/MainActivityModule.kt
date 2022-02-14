package com.gridyushko.purchases.di

import android.app.Activity
import com.gridyushko.purchases.ui.activity.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}