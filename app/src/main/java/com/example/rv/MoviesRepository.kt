package com.example.rv

class MoviesRepository(private val api: MoviesApi) : SafeApiCall() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}