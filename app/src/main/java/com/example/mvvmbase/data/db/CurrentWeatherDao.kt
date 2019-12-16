package com.example.mvvmbase.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmbase.data.db.entity.CURRENT_WEATHER_ID
import com.example.mvvmbase.data.db.entity.CurrentWeather
import com.example.mvvmbase.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.example.mvvmbase.data.db.unitlocalized.MetricCurrentWeatherEntry
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeather)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherCurrent(): LiveData<CurrentWeatherResponse>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}