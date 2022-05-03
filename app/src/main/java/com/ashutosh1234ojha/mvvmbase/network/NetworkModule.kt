package com.ashutosh1234ojha.mvvmbase.network

import android.content.Context
import com.ashutosh1234ojha.mvvmbase.api.ApiInterface
import com.ashutosh1234ojha.mvvmbase.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Ashutosh Ojha on 10,March,2022
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun getRetrofit(@ApplicationContext appContext: Context): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URLS)
            .client(getClient(appContext))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    private fun getClient(appContext: Context): OkHttpClient {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .addInterceptor(NetworkConnectionInterceptor(appContext))
            .build()
    }
}