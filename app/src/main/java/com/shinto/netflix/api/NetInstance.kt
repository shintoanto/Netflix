package com.shinto.netflix.api

import android.app.Application
import androidx.room.Room
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.shinto.netflix.NetflixDatabase
import com.shinto.netflix.utils.Constants.Companion.BASE_URL
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetInstance {


    //    private val retrofit by lazy{
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun retrofitapi(retrofit: Retrofit): Netflixapi =
        retrofit.create(Netflixapi::class.java)

    //    val api: Netflixapi by lazy {
//        retrofit.create(Netflixapi::class.java)
//    }
    @Provides
    @Singleton
    fun providesDatabase(app: Application): NetflixDatabase =
        Room.databaseBuilder(app, NetflixDatabase::class.java, "netflixdatabase_class").build()
}