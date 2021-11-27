package com.example.moviesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.network.MovieApi
import kotlinx.coroutines.launch


//9
enum class ApiStatus { LOADING , ERROR , DONE }



class MoviesViewModel: ViewModel() {

    private var _moviesList = MutableLiveData<List<ResultsItem?>>()
    val moviesList: LiveData<List<ResultsItem?>> = _moviesList

    //10
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

//12
    val movieTitle = MutableLiveData<String>()
    val movieImage = MutableLiveData<String>()
    val movieReleaseDate = MutableLiveData<String>()
    val movieVoteAverage = MutableLiveData<String>()
    val movieOverview = MutableLiveData<String>()

//11
    init {
        getMovies()
    }

    private fun getMovies() {
        println("Hello")


        //6
        viewModelScope.launch {
            //7
            try {
                //8
                _moviesList.value =
                    MovieApi.retrofitService.getPopularMovies().results

            }catch (e: Exception){
               Log.d("Error", e.message.toString())
            }
        }
    }


    //13
    fun setDetails(movieIndex: Int){

        val item = _moviesList.value?.get(movieIndex)
        movieTitle.value = item?.title
        Log.e("TAG","title:${movieTitle.value}")
        movieImage.value = item?.posterPath
        movieReleaseDate.value = item?.releaseDate
        movieVoteAverage.value = item?.voteAverage.toString()
        movieOverview.value = item?.overview
    }

}