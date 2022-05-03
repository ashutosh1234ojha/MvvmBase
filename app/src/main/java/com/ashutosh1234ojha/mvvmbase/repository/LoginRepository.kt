package com.ashutosh1234ojha.mvvmbase.repository

import com.ashutosh1234ojha.mvvmbase.api.ApiInterface
import com.ashutosh1234ojha.mvvmbase.data.login.LoginRequest
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.utils.NetworkResult
import com.ashutosh1234ojha.mvvmbase.utils.handleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 08,March,2022
 */
class LoginRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun  loginApi(email: String, password: String): Flow<NetworkResult<LoginResponse>> {
        val loginRequest = LoginRequest(email, password)
        return flow<NetworkResult<LoginResponse>> {
           val d= handleApi { apiInterface.login(loginRequest) }
            emit(d)
        }.flowOn(Dispatchers.IO)
    }
}