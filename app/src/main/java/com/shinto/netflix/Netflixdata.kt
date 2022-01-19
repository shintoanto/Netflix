package com.shinto.netflix

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Netflixtable")
data class Netflixdata(
    @PrimaryKey val name:String,
    val type:String,
    val image:String,
    val address: String
)

