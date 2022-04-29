package com.ashutosh1234ojha.mvvmbase.repository

import com.ashutosh1234ojha.mvvmbase.api.ApiInterface
import com.ashutosh1234ojha.mvvmbase.data.login.LoginRequest
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 08,March,2022
 */
class HomeRepository @Inject constructor(private val apiInterface: ApiInterface) {


}