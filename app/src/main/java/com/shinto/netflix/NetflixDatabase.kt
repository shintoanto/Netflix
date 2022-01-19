package com.shinto.netflix

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Netflixdata::class], version = 1)
abstract class NetflixDatabase:RoomDatabase() {

    abstract fun netflixDao():NetflixDao

}