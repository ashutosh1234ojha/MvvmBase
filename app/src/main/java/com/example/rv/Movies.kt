package com.example.rv


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)