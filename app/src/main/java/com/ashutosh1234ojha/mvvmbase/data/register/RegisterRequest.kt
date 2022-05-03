package com.ashutosh1234ojha.mvvmbase.data.register

/**
 * Created by Ashutosh Ojha on 10,March,2022
 */
data class RegisterRequest(
    val name: String = "",
    val email: String = "",
    val password: String = ""
)