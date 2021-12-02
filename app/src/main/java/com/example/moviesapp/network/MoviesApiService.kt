package com.example.moviesapp.network

import com.example.moviesapp.viewmodel.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()


interface MoviesApi {
    @GET("/3/movie/popular?api_key=03c0d5c4ca5f7d4b4312c4d863deba39")
    suspend fun getPopularMovies() : Response

    @GET("/3/movie/popular?api_key=03c0d5c4ca5f7d4b4312c4d863deba39")
    suspend fun getPopularMoviesByGenre(@Query("with_genres") genreID: Int): Response

    @GET("/3/discover/movie?api_key=03c0d5c4ca5f7d4b4312c4d863deba39")
    suspend fun sortPopularMoviesByReleaseDate(@Query("sort_by") releaseDate: String): Response
}

object MovieApi {
    val retrofitService : MoviesApi by lazy {
        retrofit.create(MoviesApi::class.java)
    }
}
