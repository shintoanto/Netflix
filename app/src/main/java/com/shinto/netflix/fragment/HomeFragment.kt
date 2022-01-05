package com.shinto.netflix.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.netflix.R
import com.shinto.netflix.adapter.NetflixAdapter
import com.shinto.netflix.databinding.FragmentHomeBinding
import com.shinto.netflix.repository.Repository
import com.shinto.netflix.viewmodell.MainViewModel
import com.shinto.netflix.viewmodell.MainViewModelFactory

class HomeFragment : Fragment() {

    lateinit var popularMovieadapter: NetflixAdapter
    lateinit var topratedMoviewadapter:NetflixAdapter
    lateinit var upcomingMovieAdapter:NetflixAdapter
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel : MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentHomeBinding.inflate(inflater, container, false)

        val repository= Repository()
        val viewModelFactory= MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.popularmoviesLiveData.observe(viewLifecycleOwner, { responce->
            if (responce.isSuccessful){
                if (responce.code() == 200){
                    responce.body()?.let{popularmovieResponse ->
                        popularMovieadapter.differ.submitList(popularmovieResponse.results)
                    }
                }
            }else{
                responce.message().let {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
        popularMovies()

        viewModel.getTopRatedMoviewLiveData.observe(viewLifecycleOwner, { responce->
            if (responce.isSuccessful){
                if (responce.code() == 200){
                    responce.body()?.let{topratedMoviewr ->
                        topratedMoviewadapter.differ.submitList(topratedMoviewr.results)
                    }
                }
            }else{
                responce.message().let {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
        topRatedMoview()
        viewModel.getUpcomingMoviewLiveData.observe(viewLifecycleOwner,{response ->
            if (response.isSuccessful){
                if (response.code() == 200){
                    response.body()?.let { upcomingmovies->
                        upcomingMovieAdapter.differ.submitList(upcomingmovies.results)
                    }
                }
            }else {
                response.message().let {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
        upcomingMovies()

        return binding.root
    }

    private fun popularMovies(){
        popularMovieadapter= NetflixAdapter()
        binding.poularMoviesRV.apply {
            adapter=popularMovieadapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }
    private fun topRatedMoview(){
        topratedMoviewadapter= NetflixAdapter()
        binding.toratedmoviesRV.apply {
            adapter=topratedMoviewadapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun upcomingMovies(){
        upcomingMovieAdapter= NetflixAdapter()
        binding.upcomingmoviesRV.apply {
            adapter=upcomingMovieAdapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

}