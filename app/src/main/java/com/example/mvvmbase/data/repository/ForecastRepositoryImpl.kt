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
//
//    suspend fun fetchCurrentWeather(location: String, languageCode: String) {
//
//
//        try {
//            val fetchCurrentWeatcher =
//                RetrofitClient.getApiService().getCurrentWeather(location, languageCode).await()
////                apixuWeatherApiService.getCurrentWeather(location, languageCode).await()
//
//            currentWeatherResponse=fetchCurrentWeatcher;
//            _downloadedCurrentWeather.postValue(fetchCurrentWeatcher)
//
//
//        } catch (no: NoConnectivityException) {
//
//            Log.e("NoConnectivityException", "No internet connection")
//
//        }
//
//
//    }

    //   suspend fun login(email:String,password:String):LiveData<BaseResponse>{
//
//
//
//
//
////            RetrofitClient.getApiService().login()
////                .enqueue(object : retrofit2.Callback<BaseResponse> {
////                    override fun onResponse(
////                        call: Call<BaseResponse>,
////                        response: Response<BaseResponse>
////                    ) {
////
////                        val baseMutableLiveData=MutableLiveData<BaseResponse>()
////                        return baseMutableLiveData.postValue(response.body())
////
////                    }
////
////                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
////
////                    }
////                })
//
//
//
//
//
////            return withContext(Dispatchers.IO) {
////               fetchCurrentWeather(email,password)
////        }
//   return    fetchLoginResponse(email, password)
//
//     //  return CommonData.getLoginResponse()
//
//
//    }

    suspend fun login(email: String, password: String)  {

        //  DataSource.fetchLogin(email,password)
//        val mutableBaseResponse = MutableLiveData<CurrentWeatherResponse>()



        try {
            val fetchedLoginResponse: CurrentWeatherResponse = RetrofitClient.getApiService().getCurrentWeather(email, password).await()
//                .getCurrentWeather(location, languageCode)
//                .await()
            //_downloadedCurrentWeather.postValue(fetchedCurrentWeather)

            //Todo Add data to db
            //  DataSource.fetchLogin(email,password)
        currentWeatherResponse=fetchedLoginResponse;
        _downloadedCurrentWeather.postValue(fetchedLoginResponse)
           // return mutableBaseResponse



        }
//
        catch (e: Exception) {
//
//            val baseResponse = BaseResponse(null, null, null)
//          //  baseResponse.msg = "Network error"
//            //baseResponse.statusCode = 100
//
//            mutableBaseResponse.postValue(baseResponse)
//            return mutableBaseResponse
//            //   Log.e("Connectivity", "No internet connection.", e)
        }

    }

}