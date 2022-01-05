package com.shinto.netflix.Model

data class MovieResponce(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)