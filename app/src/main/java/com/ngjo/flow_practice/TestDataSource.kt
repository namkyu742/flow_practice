package com.ngjo.flow_practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat

class TestDataSource {
    private fun getTimeToString(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())

    fun getTimeToStringFive(): Flow<String> = flow {
        for(i in 1..5) {
            emit(getTimeToString())
            delay(1000)
        }
    }
}
