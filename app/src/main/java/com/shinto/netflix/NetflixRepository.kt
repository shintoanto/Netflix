package com.shinto.netflix

import androidx.room.withTransaction
import com.shinto.netflix.api.Netflixapi
import javax.inject.Inject

class NetflixRepository @Inject constructor(
    private val api: Netflixapi,
    private val db: NetflixDatabase
) {
    private val netflixdao = db.netflixDao()

    fun getAllNetflix() = networkBoundResource(
        query = {
            netflixdao.getAllNetflixMovies()
        },
        fetch = {
            api.getUpcomingMoview()
        },
        saveFetchResult = { netflixData ->
            db.withTransaction {
                netflixdao.deleteNetflixtabel()
                netflixdao.insertNetflixData(netflixData)
            }
        }


    )


}