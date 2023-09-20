package com.ngjo.flow_practice.data_layer.datasource.di

import com.ngjo.flow_practice.data_layer.datasource.TestDataSource
import com.ngjo.flow_practice.data_layer.datasource.TestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsTestDataSource(
        testDataSource: TestDataSourceImpl
    ) : TestDataSource

}