package com.chimdike.core.network.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.chimdike.core.network.ConnectionChecker
import com.chimdike.core.network.ConnectionCheckerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object ConnectivityModule {


    @Singleton
    @Provides
    fun provideConnectivityManager(@ApplicationContext app: Application): ConnectivityManager {
        return  app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}