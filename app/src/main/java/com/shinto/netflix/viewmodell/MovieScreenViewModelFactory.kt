package com.shinto.netflix.viewmodell

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shinto.netflix.Model.Result

class MovieScreenViewModelFactory(private val repository: Result):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieScreenViewModel(repository) as T
    }

}
