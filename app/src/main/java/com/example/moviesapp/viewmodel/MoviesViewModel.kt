package com.example.moviesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.network.MovieApi
import kotlinx.coroutines.launch


class MoviesViewModel: ViewModel() {
    private var _moviesList = MutableLiveData<List<ResultsItem?>>()
    val moviesList: LiveData<List<ResultsItem?>> = _moviesList


    init {
        getMovies()
    }


    private fun getMovies() {
        viewModelScope.launch {
            try {
                _moviesList.value =
                    MovieApi.retrofitService.getPopularMovies().results
                println(_moviesList.value)

            }catch (e: Exception){
               Log.d("Error", e.message.toString())
            }
        }
    }




}