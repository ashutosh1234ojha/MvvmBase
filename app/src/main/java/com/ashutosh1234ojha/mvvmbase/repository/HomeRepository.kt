package com.ashutosh1234ojha.mvvmbase.repository

import com.ashutosh1234ojha.mvvmbase.api.ApiInterface
import com.ashutosh1234ojha.mvvmbase.data.login.LoginRequest
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.data.register.RegisterRequest
import com.ashutosh1234ojha.mvvmbase.data.register.RegisterResponse
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
class HomeRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun registerApi(registerRequest: RegisterRequest): Flow<NetworkResult<RegisterResponse>> {

        return flow<NetworkResult<RegisterResponse>> {
            val d = handleApi { apiInterface.registration(registerRequest) }
            emit(d)
        }.flowOn(Dispatchers.IO)

    }


}