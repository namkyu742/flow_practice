package com.ngjo.flow_practice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    private val testDataSource = TestDataSource()

    private val _uiState = MutableStateFlow("")
    val uiState : StateFlow<String> = _uiState.asStateFlow()

    fun onClickTestButton() {
        Log.d("TEST", "------------ TEST START ------------")

        viewModelScope.launch {
            testDataSource.getTimeToStringFive().collect { time ->
                Log.d("TEST", "    $time")
                _uiState.update { time }
            }
        }
    }


}