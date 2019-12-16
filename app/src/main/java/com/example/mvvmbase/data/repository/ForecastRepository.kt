package com.example.mvvmbase.data.repository

import androidx.lifecycle.LiveData
import com.example.mvvmbase.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse

interface ForecastRepository {
    suspend fun getCurrentWeather(): LiveData<out CurrentWeatherResponse>

}
