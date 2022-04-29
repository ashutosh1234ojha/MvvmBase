package com.ashutosh1234ojha.mvvmbase.utils

/**
 * Created by Ashutosh Ojha on 09,March,2022
 */
sealed class Resource<T>(val data: T? = null, val error: Throwable? = null) {

    class Success<T>(data: T?) : Resource<T>(data)
    class Loading<T>(data: T?) : Resource<T>(data)
    class Error<T>(data: T? = null, throwable: Throwable) : Resource<T>(data, throwable)


}