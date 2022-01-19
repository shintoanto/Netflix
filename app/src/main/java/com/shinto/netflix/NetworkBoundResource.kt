package com.shinto.netflix

import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType>networkBoundResource(
    // for getting data from data base
   crossinline query:() -> Flow<ResultType>,
// fetching new data from data from REST api
crossinline fetch:suspend() -> RequestType,
    //saving the new data to the Database
crossinline saveFetchResult: suspend (RequestType) -> Unit,
    // decide whether to fetch new data from api or from database
crossinline shouldFetch:(ResultType) -> Boolean = { true }
) = flow{
    val data = query().first()

    val flow = if(shouldFetch(data)){
        emit(com.shinto.netflix.util.Resource.Loading(data))
        try{
            saveFetchResult(fetch())
            query().map { com.shinto.netflix.util.Resource.Sucsess(it) }
        }catch (throwable:Throwable){
            query().map { com.shinto.netflix.util.Resource.Error(throwable,it) }
        }

        }else{
            query().map { com.shinto.netflix.util.Resource.Sucsess(it) }
    }
    emit(flow)
}
