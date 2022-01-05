package com.shinto.netflix.repository

import com.shinto.netflix.Model.MovieResponce
import com.shinto.netflix.api.NetInstance
import retrofit2.Response

class Repository {
    suspend fun getPopular(): Response<MovieResponce> {
        return NetInstance.api.getPopularmovies()
    }

    suspend fun getTopRated():Response<MovieResponce>{
        return NetInstance.api.getTopRatedmovies()
    }

    suspend fun getUpcoming():Response<MovieResponce>{
        return NetInstance.api.getUpcomingMoview()
    }
}