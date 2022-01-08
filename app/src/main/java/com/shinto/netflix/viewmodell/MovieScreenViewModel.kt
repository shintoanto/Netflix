package com.shinto.netflix.viewmodell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shinto.netflix.Model.Result
import com.shinto.netflix.repository.Repository

class MovieScreenViewModel(var secondPageImagesRep: Result) : ViewModel() {
    val headImageLiveDatad: MutableLiveData<String> = MutableLiveData()
    val smallImageLiveData: MutableLiveData<String> = MutableLiveData()
    val titleLiveData: MutableLiveData<String> = MutableLiveData()
    val discriptionData: MutableLiveData<String> = MutableLiveData()

    init {
        secondPageImages()
    }

    fun secondPageImages(){
        headImageLiveDatad.value = secondPageImagesRep.backdrop_path
        titleLiveData.value = secondPageImagesRep.title
        discriptionData.value = secondPageImagesRep.overview
        smallImageLiveData.value = secondPageImagesRep.poster_path    }


}