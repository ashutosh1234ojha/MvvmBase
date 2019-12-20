package com.example.mvvmbase.today

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.data.repository.ForecastRepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TodayWeatherViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: ForecastRepositoryImpl = ForecastRepositoryImpl(application)

    var live= MutableLiveData<CurrentWeatherResponse>()
    fun getCurrentWeather(location:String,lan:String):LiveData<CurrentWeatherResponse>{

        GlobalScope.async {
         live=   repository.fetchCurrentWeather(location,lan)



        }
        return live
    }
}
