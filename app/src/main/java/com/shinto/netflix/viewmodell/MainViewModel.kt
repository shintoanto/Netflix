package com.shinto.netflix.viewmodell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinto.netflix.Model.MovieResponce
import com.shinto.netflix.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val popularmoviesLiveData: MutableLiveData<Response<MovieResponce>> = MutableLiveData()
    val getTopRatedMoviewLiveData:MutableLiveData<Response<MovieResponce>> = MutableLiveData()
    val getUpcomingMoviewLiveData:MutableLiveData<Response<MovieResponce>> = MutableLiveData()
    val nowPlayingMoviesLiveData:MutableLiveData<Response<MovieResponce>> = MutableLiveData()

    init {
        popularMovies()
        getTopRatedMovies()
        getUpcomimgMovies()
        nowPlayingMovies()
    }
    fun popularMovies(){
        viewModelScope.launch {
            val respose: Response<MovieResponce> = repository.getPopular()
            popularmoviesLiveData.value = respose
        }
    }
    fun nowPlayingMovies(){
        viewModelScope.launch {
            val responce:Response<MovieResponce> = repository.nowPlaying()
            nowPlayingMoviesLiveData.value = responce
        }
    }

    fun getTopRatedMovies(){
        viewModelScope.launch {
            val response:Response<MovieResponce> = repository.getTopRated()
            getTopRatedMoviewLiveData.value =response
        }
    }
    fun getUpcomimgMovies() {
        viewModelScope.launch {
            val response:Response<MovieResponce> = repository.getUpcoming()
            getUpcomingMoviewLiveData.value = response
        }
    }
}