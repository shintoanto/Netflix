package com.shinto.netflix.util

sealed class Resource<T>(
    data: T? = null,
    error: Throwable? = null
) {
    class Sucsess<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable)
}