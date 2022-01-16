package com.shinto.netflix.util

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shinto.netflix.Model.MovieResponce

@Dao
interface Movies {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies:List<MovieResponce>)

//    @Query("DELETE  FROM ")
}