package com.example.rv

import com.example.mvvmbase.data.network.API_KEY
import com.example.mvvmbase.data.network.RetrofitClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("/todos")
    suspend fun getMovies(): Response<List<Movies>>

    companion object {

        operator fun invoke(): MoviesApi {

            return Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(MoviesApi::class.java)
        }

        var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder().addInterceptor(logging)


    }


}