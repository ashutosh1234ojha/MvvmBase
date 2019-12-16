package com.example.mvvmbase.data.network

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(private val apixuWeatherApiService: ApixuWeatherApiService) :
    WeatherNetworkDataSource {

    val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {


        try {
            val fetchCurrentWeatcher =
                apixuWeatherApiService.getCurrentWeather(location, languageCode).await()

            _downloadedCurrentWeather.postValue(fetchCurrentWeatcher)
        } catch (no: NoConnectivityException) {

            Log.e("NoConnectivityException", "No internet connection")

        }


    }

    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather
}