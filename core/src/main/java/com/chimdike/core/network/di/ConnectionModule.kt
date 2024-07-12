package com.chimdike.core.network.di

import com.chimdike.core.network.ConnectionChecker
import com.chimdike.core.network.ConnectionCheckerImpl
import com.chimdike.core.network.Network
import com.chimdike.core.network.NetworkExt
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoreModule {

    @Binds
    fun bindConnectionChecker(impl: ConnectionCheckerImpl): ConnectionChecker

    @Binds
    fun bindNetwork(impl: NetworkExt):Network
}