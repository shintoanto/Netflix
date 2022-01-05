package com.shinto.netflix.api

import com.shinto.netflix.Model.MovieResponce
import com.shinto.netflix.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Netflixapi {
    @GET("popular?")
    suspend fun getPopularmovies(
        @Query("api_key") apiKey:String = API_KEY
    ):Response<MovieResponce>

    @GET("top_rated?")
    suspend fun getTopRatedmovies(
        @Query("api_key") apiKey:String = API_KEY
    ):Response<MovieResponce>

    @GET("upcoming?")
    suspend fun getUpcomingMoview(
        @Query("api_key") apiKey: String = API_KEY
    ):Response<MovieResponce>
}