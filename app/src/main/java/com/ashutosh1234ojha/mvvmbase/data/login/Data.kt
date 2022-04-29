package com.ashutosh1234ojha.mvvmbase.data.login


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("Id")
    val _Id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Token")
    val token: String
)