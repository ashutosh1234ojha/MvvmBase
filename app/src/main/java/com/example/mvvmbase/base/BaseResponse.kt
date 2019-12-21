package com.example.mvvmbase.base

import com.example.mvvmbase.data.db.Location
import com.example.mvvmbase.data.db.Request
import com.example.mvvmbase.data.db.entity.CurrentWeather

open class BaseResponse(
    currentWeather: CurrentWeather?,
    location: Location?,
    request: Request?
) {
}