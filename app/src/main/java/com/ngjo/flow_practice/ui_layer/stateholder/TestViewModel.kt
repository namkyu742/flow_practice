package com.ngjo.flow_practice.ui_layer.stateholder

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngjo.flow_practice.data_layer.datasource.TestDataSourceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testDataSource: TestDataSourceImpl
) : ViewModel() {

//    private val testDataSource = TestDataSource()

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