package com.example.moviesapp.network

import com.example.moviesapp.viewmodel.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface MoviesApi {
    @GET("/3/movie/popular?api_key=03c0d5c4ca5f7d4b4312c4d863deba39")
    suspend fun getPopularMovies(): Response
}

object MovieApi {
    val retrofitService : MoviesApi by lazy {
        retrofit.create(MoviesApi::class.java)
    }
}
