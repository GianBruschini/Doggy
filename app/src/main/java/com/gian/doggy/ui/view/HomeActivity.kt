package com.gian.doggy.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.gian.doggy.R
import com.gian.doggy.databinding.ActivityHomeBinding
import com.gian.doggy.ui.viewmodel.HomeActivityViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val breedsViewModel: HomeActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        breedsViewModel.onCreate()

        breedsViewModel.getAllBreedsLiveData.observe(this, Observer {
            //actualiza el recycler view
        })
        breedsViewModel.isLoadingLiveData.observe(this, Observer {
            binding.progressBar.visibility = View.VISIBLE
        })

    }
}