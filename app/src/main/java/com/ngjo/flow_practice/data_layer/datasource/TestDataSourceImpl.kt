package com.ngjo.flow_practice.data_layer.datasource

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import javax.inject.Inject


class TestDataSourceImpl @Inject constructor(): TestDataSource {
    override fun getTimeToString(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())

    override fun getTimeToStringFive(): Flow<String> = flow {
        for(i in 1..5) {
            emit(getTimeToString())
            delay(1000)
        }
    }
}
