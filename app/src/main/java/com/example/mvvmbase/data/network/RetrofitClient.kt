package com.example.mvvmbase.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "http://api.weatherstack.com/";

object RetrofitClient {

    private lateinit var retrofit: Retrofit

    //TODO  Make retrofit singleton
    fun getApiService(): ApixuWeatherApiService {
        retrofit = Retrofit.Builder().client(getHttpClient()).baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit.create(ApixuWeatherApiService::class.java)
    }

    //TODO  add connectivity interceptor
    fun getHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(getRequestInterceptor())
            //  .addInterceptor(connectivityInterceptor)
            .build()

        return okHttpClient
    }

    fun getRequestInterceptor(): Interceptor {
        val requestInterceptor = Interceptor { chain ->

            val url =
                chain.request().url().newBuilder().addQueryParameter(
                    "access_key",
                    API_KEY
                ).build()

            val request = chain.request().newBuilder().url(url).build()

            return@Interceptor chain.proceed(request)

        }

        return requestInterceptor
    }
}