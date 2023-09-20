package com.ngjo.flow_practice.data_layer.datasource

import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface TestDataSource {
    fun getTimeToString(): String
    fun getTimeToStringFive(): Flow<String>

}