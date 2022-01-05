package com.shinto.netflix

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.shinto.netflix.adapter.NetflixAdapter
import com.shinto.netflix.databinding.ActivityMainBinding
import com.shinto.netflix.databinding.FragmentHomeBinding
import com.shinto.netflix.repository.Repository
import com.shinto.netflix.viewmodell.MainViewModel
import com.shinto.netflix.viewmodell.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                ?: return

        val navController = host.navController
        var actionBar=supportActionBar

        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.BLACK))
        setupActionBarWithNavController(navController)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
      //  viewModel.
    }

}