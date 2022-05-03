package com.ashutosh1234ojha.mvvmbase.api

import com.ashutosh1234ojha.mvvmbase.data.login.Data
import com.ashutosh1234ojha.mvvmbase.data.login.LoginRequest
import com.ashutosh1234ojha.mvvmbase.data.login.LoginResponse
import com.ashutosh1234ojha.mvvmbase.data.register.RegisterRequest
import com.ashutosh1234ojha.mvvmbase.data.register.RegisterResponse
import com.ashutosh1234ojha.mvvmbase.model.CommonResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Ashutosh Ojha on 10,March,2022
 * https://www.appsloveworld.com/sample-rest-api-url-for-testing-with-authentication/
 *     "email":"sdf@gmail.com",
"password":123456
 */
interface ApiInterface {

    @POST("/api/authaccount/login")
    suspend fun  login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/api/authaccount/registration")
    suspend fun  registration(@Body loginRequest: RegisterRequest): Response<RegisterResponse>


}