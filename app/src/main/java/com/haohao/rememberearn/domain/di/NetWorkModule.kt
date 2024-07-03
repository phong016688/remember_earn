package com.haohao.rememberearn.domain.di

import com.haohao.rememberearn.utils.ConnectivityManagerNetworkMonitor
import com.haohao.rememberearn.utils.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetWorkModule {
    @Binds
    abstract fun bindNetworkMonitor(connectivityManager: ConnectivityManagerNetworkMonitor): NetworkMonitor
}