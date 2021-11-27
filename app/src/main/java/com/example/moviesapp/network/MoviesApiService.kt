package com.example.moviesapp.network

import com.example.moviesapp.viewmodel.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//1
private const val BASE_URL = "https://api.themoviedb.org"
//2
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//2
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()
//4
interface MoviesApi {
    @GET("/3/movie/popular?api_key=03c0d5c4ca5f7d4b4312c4d863deba39")

    //5
    suspend fun getPopularMovies(): Response
}
//3
object MovieApi {
    val retrofitService : MoviesApi by lazy {
        retrofit.create(MoviesApi::class.java)
    }
}
