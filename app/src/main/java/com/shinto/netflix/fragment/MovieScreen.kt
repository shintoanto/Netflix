package com.shinto.netflix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.shinto.netflix.databinding.FragmentMovieScreenBinding
import com.shinto.netflix.viewmodell.MovieScreenViewModel
import com.shinto.netflix.viewmodell.MovieScreenViewModelFactory

class MovieScreen : Fragment() {
    lateinit var binding: FragmentMovieScreenBinding
    lateinit var viewModelMovieScreen: MovieScreenViewModel
    val ars: MovieScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieScreenBinding.inflate(inflater, container, false)
        val movieScreenFactory = MovieScreenViewModelFactory(ars.movieResult)
        viewModelMovieScreen =
            ViewModelProvider(this, movieScreenFactory).get(MovieScreenViewModel::class.java)

        viewModelMovieScreen.headImageLiveDatad.observe(requireActivity(), Observer {
            Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500${it}")
                .into(binding.mainDetailedImg)
        })

        viewModelMovieScreen.titleLiveData.observe(requireActivity(), Observer {
            binding.movieHeading.text = it
        })
        viewModelMovieScreen.discriptionData.observe(requireActivity(), Observer {
            binding.movieDiscription.text = it
        })
        viewModelMovieScreen.smallImageLiveData.observe(requireActivity(), Observer {
            Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500${it}")
                .into(binding.imageVie)
        })
        return binding.root
    }


}