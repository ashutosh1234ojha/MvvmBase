package com.ashutosh1234ojha.mvvmbase.data.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val code: Int,
    val `data`: Data,
    @SerializedName("id")
    val id: String,
    val message: String
)