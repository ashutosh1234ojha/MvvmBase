package com.ashutosh1234ojha.mvvmbase.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ashutosh1234ojha.mvvmbase.data.login.Data
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.model.LoginRequest
import com.ashutosh1234ojha.mvvmbase.repository.LoginRepository
import com.ashutosh1234ojha.mvvmbase.utils.NetworkResult
import com.google.gson.internal.LinkedTreeMap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Ashutosh Ojha on 21,February,2022
 * https://medium.com/mobile-app-development-publication/injecting-viewmodel-with-dagger-hilt-54ca2e433865
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : BaseViewModel() {
    val user = LoginRequest("", "")

    private val _errorMsgEmail = MutableLiveData<String>()
    val errorMsgEmail: LiveData<String> = _errorMsgEmail

    private val _errorMsgPassword = MutableLiveData<String>()
    val errorMsgPassword: LiveData<String> = _errorMsgPassword

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    private val _successLogin = MutableLiveData<Data>()
    val successLogin: LiveData<Data> = _successLogin

    //This  method  get called from fragment_login.xml
    fun handleLogin() {
        Log.d("LoginRepository", loginRepository.toString())
        when {
            user.email.isEmpty() -> {
                _errorMsgEmail.value = "Email is empty"
            }
            user.password.isEmpty() -> {
                _errorMsgPassword.value = "Password is empty"
            }
            else -> {

                viewModelScope.launch {
                    loginRepository.loginApi(user.email, user.password)
                        .collect { commonResponse ->

                            Log.d("c", commonResponse.toString())

                            when (commonResponse) {
                                is NetworkResult.Success<LoginResponse> -> {
                                    _successLogin.value = commonResponse.data.data
                                }

                                is NetworkResult.Error<*> -> {
                                    _errorMsg.value = commonResponse.message!!

                                }
                                is NetworkResult.Exception<*> -> {
                                    _errorMsg.value = "Something went wrong"
                                }
                            }

                        }
                }
            }
        }
    }
}