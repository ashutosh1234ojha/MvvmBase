package com.example.rv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {
    private val _movies=MutableLiveData<List<Movies>>()
     val movies :LiveData<List<Movies>>

    get() = _movies

    private lateinit var job: Job

    fun getMovies(){
        job= Couroutines.ioThenMain(
            {repository.getMovies()},
            {
                _movies.value=it
            }
        )


//     val movies= repository.getMovies()
//      _movies.value=movies
    }

    override fun onCleared() {
        super.onCleared()

        if(::job.isInitialized)job.cancel()
    }

}
