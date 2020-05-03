package com.example.mvvmbase.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbase.base.BaseResponse
import com.example.mvvmbase.data.network.RetrofitClient
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse

object ForecastRepositoryImpl{

    val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    lateinit var currentWeatherResponse:CurrentWeatherResponse


    fun getView():CurrentWeatherResponse{
        return currentWeatherResponse
    }


    suspend fun login(email: String, password: String)  {


        try {
            val fetchedLoginResponse: CurrentWeatherResponse = RetrofitClient.getApiService().getCurrentWeather(email, password).await()


            //Todo Add data to db
            //  DataSource.fetchLogin(email,password)
        currentWeatherResponse=fetchedLoginResponse;
        _downloadedCurrentWeather.postValue(fetchedLoginResponse)

        }
        catch (e: Exception) {

        }

    }

}