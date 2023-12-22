package com.bangkit.pregai.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.bangkit.pregai.data.auth.UserAuthDataSourceImpl
import com.bangkit.pregai.data.auth.UserDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindsAuthStateDataSource(dataSource: UserAuthDataSourceImpl): UserDataSource
}