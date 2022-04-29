package com.ashutosh1234ojha.mvvmbase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by Ashutosh Ojha on 21,February,2022
 */
class SplashViewModel : BaseViewModel() {

    private val _mutableStateFlow = MutableStateFlow(false)
    var stateFlow: StateFlow<Boolean> = _mutableStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            _mutableStateFlow.value = true


        }
    }
}