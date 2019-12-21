package com.example.mvvmbase.today

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmbase.base.BaseResponse
import com.example.mvvmbase.base.BaseViewModel
import com.example.mvvmbase.data.network.response.CurrentWeatherResponse
import com.example.mvvmbase.data.repository.ForecastRepositoryImpl
import kotlinx.coroutines.*

class TodayWeatherViewModel (application: Application) : BaseViewModel(application) {
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun validateLogin(): Boolean {
        return true
    }


     var liveBaseResponse=MutableLiveData<CurrentWeatherResponse>()


    fun login(email: String, password: String) {
//      GlobalScope.launch(Dispatchers.IO) {

        uiScope.launch {
              ForecastRepositoryImpl.login(email, password)

            liveBaseResponse.postValue(ForecastRepositoryImpl.getView())
            return@launch
        }

        // return   LoginRepository.login(email,password)
        // return liveBaseResponse

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}


//     fun showLoader() {
//
//    }
//
//     fun hideLoader() {
//    }
