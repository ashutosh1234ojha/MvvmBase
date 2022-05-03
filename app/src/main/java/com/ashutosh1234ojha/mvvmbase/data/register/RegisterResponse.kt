package com.ashutosh1234ojha.mvvmbase.data.register


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    val code: Int,
    val `data`: Data,
    @SerializedName("id")
    val id: String,
    val message: String
)