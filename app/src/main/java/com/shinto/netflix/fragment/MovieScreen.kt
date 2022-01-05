package com.shinto.netflix.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.shinto.netflix.R

class MovieScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_screen, container, false)
        view.findViewById<TextView>(R.id.movie_text).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_movieScreen_to_homeFragment)
        }
        return view
    }

}