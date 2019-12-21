package com.example.mvvmbase.data.network.response

import com.example.mvvmbase.base.BaseResponse
import com.example.mvvmbase.data.db.entity.CurrentWeather
import com.example.mvvmbase.data.db.Location
import com.example.mvvmbase.data.db.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    val location: Location,
    val request: Request
):BaseResponse(currentWeather,location,request)