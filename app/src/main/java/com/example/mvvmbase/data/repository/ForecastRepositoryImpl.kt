package com.example.mvvmbase.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbase.data.db.CurrentWeatherDao
import com.example.mvvmbase.data.network.RetrofitClient
import com.example.mvvmbase.data.network.WeatherNetworkDataSource
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.internal.NoConnectivityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import java.util.*

object ForecastRepositoryImpl{

//    init {
//        weatherNetworkDataSource.downloadedCurrentWeather.observeForever {
//            persistFetchedCurrentWeather(it)
//        }
//    }
//
//
//    override suspend fun getCurrentWeather(): LiveData<out CurrentWeatherResponse> {
//        return withContext(Dispatchers.IO) {
//            initWeatherData()
//            return@withContext  currentWeatherDao.getWeatherCurrent()
//        }    }
//
//
//    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse) {
//        GlobalScope.launch(Dispatchers.IO) {
//            currentWeatherDao.upsert(fetchedWeather.currentWeather)
//        }
//    }
//
//    private suspend fun initWeatherData() {
//
//        if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1)))
//            fetchCurrentWeather()
//
//    }
//
//    private suspend fun fetchCurrentWeather() {
//        weatherNetworkDataSource.fetchCurrentWeather(
//            "London",
//            Locale.getDefault().language
//        )
//    }
//
//    @SuppressLint("NewApi")
//    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
//        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
//        return lastFetchTime.isBefore(thirtyMinutesAgo)
//    }

    val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
   lateinit var currentWeatherResponse:CurrentWeatherResponse


    fun getView():CurrentWeatherResponse{
        return currentWeatherResponse
    }

    suspend fun fetchCurrentWeather(location: String, languageCode: String) {


        try {
            val fetchCurrentWeatcher =
                RetrofitClient.getApiService().getCurrentWeather(location, languageCode).await()
//                apixuWeatherApiService.getCurrentWeather(location, languageCode).await()

            currentWeatherResponse=fetchCurrentWeatcher;
            _downloadedCurrentWeather.postValue(fetchCurrentWeatcher)


        } catch (no: NoConnectivityException) {

            Log.e("NoConnectivityException", "No internet connection")

        }


    }

}