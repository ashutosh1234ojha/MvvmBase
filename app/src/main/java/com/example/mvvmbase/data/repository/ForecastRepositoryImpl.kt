package com.example.mvvmbase.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.example.mvvmbase.data.db.CurrentWeatherDao
import com.example.mvvmbase.data.network.WeatherNetworkDataSource
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import java.util.*

class ForecastRepositoryImpl(private val currentWeatherDao: CurrentWeatherDao,
                             private val weatherNetworkDataSource: WeatherNetworkDataSource
                             ) : ForecastRepository {

    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever {
            persistFetchedCurrentWeather(it)
        }
    }


    override suspend fun getCurrentWeather(): LiveData<out CurrentWeatherResponse> {
        return withContext(Dispatchers.IO) {
            initWeatherData()
            return@withContext  currentWeatherDao.getWeatherCurrent()
        }    }


    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedWeather.currentWeather)
        }
    }

    private suspend fun initWeatherData() {

        if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1)))
            fetchCurrentWeather()

    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.fetchCurrentWeather(
            "London",
            Locale.getDefault().language
        )
    }

    @SuppressLint("NewApi")
    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }


}