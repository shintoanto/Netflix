package com.shinto.netflix

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shinto.netflix.Model.MovieResponce
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NetflixDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNetflixData(netflixdata: Response<MovieResponce>)

    @Query("DELETE FROM  Netflixtable")
    suspend fun deleteNetflixtabel()

    @Query("SELECT * FROM Netflixtable")
    fun getAllNetflixMovies():Flow<List<Netflixdata>>
}