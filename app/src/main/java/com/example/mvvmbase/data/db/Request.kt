package com.example.mvvmbase.data.db



data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)