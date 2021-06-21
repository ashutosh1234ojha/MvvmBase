package com.example.rv

import retrofit2.Response
import java.io.IOException

abstract class SafeApiCall {

    //we have created this fun as a generic fun, so that when ever we have to execute a api call we will pass
    // that api here and get the result
    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            //@todo handle api exception
            throw ApiException(response.code().toString())
        }
    }

}

class ApiException(message: String): IOException(message)