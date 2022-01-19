package com.shinto.netflix

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface NetflixDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNetflixData(netflixdata:List<Netflixdata>)

    @Query("DELETE FROM  Netflixtable")
    suspend fun deleteNetflixtabel()

    @Query("SELECT * FROM Netflixtable")
    fun getAllNetflixMovies():Flow<List<Netflixdata>>
}