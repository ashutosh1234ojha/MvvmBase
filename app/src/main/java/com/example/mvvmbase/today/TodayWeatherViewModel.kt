package com.example.mvvmbase.today

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.data.repository.ForecastRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodayWeatherViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()


    fun get(location: String,lan: String) {
        GlobalScope.launch(Dispatchers.Main) {
            ForecastRepositoryImpl.fetchCurrentWeather(location,lan)

        //   _downloadedCurrentWeather= ForecastRepositoryImpl.getView()
            _downloadedCurrentWeather.postValue(ForecastRepositoryImpl.getView())
        }

    }

}
