package com.example.mvvmbase.data.network

import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "5b3b3252cfc76cf4192d545d8921da81"

interface ApixuWeatherApiService {

    @GET("/current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): ApixuWeatherApiService {

            val requestInterceptor = Interceptor { chain ->

                val url =
                    chain.request().url().newBuilder().addQueryParameter("access_key",
                        API_KEY
                    ).build()

                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder().client(okHttpClient).baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }

}