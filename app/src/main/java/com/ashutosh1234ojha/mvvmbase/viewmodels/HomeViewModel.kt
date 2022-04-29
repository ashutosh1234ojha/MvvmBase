package com.ashutosh1234ojha.mvvmbase.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh1234ojha.mvvmbase.data.login.Data
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.model.LoginRequest
import com.ashutosh1234ojha.mvvmbase.repository.HomeRepository
import com.ashutosh1234ojha.mvvmbase.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 21,February,2022
 * https://medium.com/mobile-app-development-publication/injecting-viewmodel-with-dagger-hilt-54ca2e433865
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loginRepository: HomeRepository,
) : BaseViewModel() {

}