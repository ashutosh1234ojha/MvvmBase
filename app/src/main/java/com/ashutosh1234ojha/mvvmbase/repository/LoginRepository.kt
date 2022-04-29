package com.ashutosh1234ojha.mvvmbase.repository

import com.ashutosh1234ojha.mvvmbase.api.ApiInterface
import com.ashutosh1234ojha.mvvmbase.data.login.Data
import com.ashutosh1234ojha.mvvmbase.data.login.LoginRequest
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.model.CommonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 08,March,2022
 */
class LoginRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun <T>loginApi(email: String, password: String): Flow<CommonResponse<T>> {
        val loginRequest = LoginRequest(email, password)
        return flow<CommonResponse<T>> {
            val loginData = apiInterface.login<T>(loginRequest)
            emit(loginData)
        }.flowOn(Dispatchers.IO)
    }
}