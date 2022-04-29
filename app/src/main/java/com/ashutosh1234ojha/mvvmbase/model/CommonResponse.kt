package com.ashutosh1234ojha.mvvmbase.model

/**
 * Created by Ashutosh Ojha on 15,March,2022
 */
data class CommonResponse<T>(val code: Int, val message: String, val data: T)