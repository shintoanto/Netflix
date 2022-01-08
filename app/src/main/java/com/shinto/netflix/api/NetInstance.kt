package com.shinto.netflix.api

import com.shinto.netflix.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:Netflixapi by lazy {
        retrofit.create(Netflixapi::class.java)
    }

}