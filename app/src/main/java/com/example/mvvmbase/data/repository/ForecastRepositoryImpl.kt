package com.example.mvvmbase.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbase.data.db.CurrentWeatherDao
import com.example.mvvmbase.data.db.ForecastDatabase
import com.example.mvvmbase.data.db.entity.CurrentWeather
import com.example.mvvmbase.data.network.RetrofitClient
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.internal.NoConnectivityException

class ForecastRepositoryImpl(application: Application) {

   // var currentWeatherDao: CurrentWeatherDao

    val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()


    init {
     //   currentWeatherDao=ForecastDatabase.
    }


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

        private suspend fun fetchCurrentWeather() :LiveData<CurrentWeatherResponse>{
//        weatherNetworkDataSource.fetchCurrentWeather(
//            "London",
//            Locale.getDefault().language
//        )

         return   _downloadedCurrentWeather
    }

     suspend fun fetchCurrentWeather(location: String, languageCode: String) {


         val mut=MutableLiveData<CurrentWeatherResponse>()
//        try {
            val fetchCurrentWeatcher =
                RetrofitClient.getApiService().getCurrentWeather(location, languageCode).await()

            mut.postValue(fetchCurrentWeatcher)

//            return mut

//        }
//        catch (no: NoConnectivityException) {
//
//            Log.e("NoConnectivityException", "No internet connection")
//
//
//        }


    }

}