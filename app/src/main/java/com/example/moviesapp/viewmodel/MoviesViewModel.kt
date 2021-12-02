package com.example.moviesapp.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.network.MovieApi
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }



class MoviesViewModel : ViewModel() {
    private var _moviesList = MutableLiveData<List<ResultsItem?>>()
    val moviesList: LiveData<List<ResultsItem?>> = _moviesList
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    val movieTitle = MutableLiveData<String>()
    val movieImage = MutableLiveData<String>()
    val movieReleaseDate = MutableLiveData<String>()
    val movieVoteAverage = MutableLiveData<String>()
    val movieOverview = MutableLiveData<String>()
    val movieId = MutableLiveData<Int>()


    init {
        getMovies()
    }


    fun getMovies() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _moviesList.value =
                    MovieApi.retrofitService.getPopularMovies().results
                _status.value = ApiStatus.DONE


            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                _status.value = ApiStatus.ERROR
                _moviesList.value = mutableListOf()
            }
        }
    }

    fun getMoviesByGenre(genreId: Int) {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _moviesList.value =
                    MovieApi.retrofitService.getPopularMoviesByGenre(genreId).results
                _status.value = ApiStatus.DONE


            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                _status.value = ApiStatus.ERROR
                _moviesList.value = mutableListOf()
            }
        }
    }


    fun sortMoviesByReleaseDate(releaseDateYear: Int) {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _moviesList.value =
                    MovieApi.retrofitService.sortPopularMoviesByReleaseDate(releaseDateYear).results
                _status.value = ApiStatus.DONE


            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                _status.value = ApiStatus.ERROR
                _moviesList.value = mutableListOf()
            }
        }
    }


    fun setDetails(movieIndex: Int) {

        val item = _moviesList.value?.get(movieIndex)
        movieTitle.value = item?.title
        movieImage.value = item?.posterPath
        movieReleaseDate.value = item?.releaseDate
        movieVoteAverage.value = item?.voteAverage.toString()
        movieOverview.value = item?.overview
        movieId.value = item?.id
    }


}