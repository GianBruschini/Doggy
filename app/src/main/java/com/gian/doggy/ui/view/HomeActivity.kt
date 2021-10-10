package com.gian.doggy.ui.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.gian.doggy.R
import com.gian.doggy.data.model.Message
import com.gian.doggy.databinding.ActivityHomeBinding
import com.gian.doggy.ui.adapters.AllBreedsAdapter
import com.gian.doggy.ui.viewmodel.HomeActivityViewModel


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val breedsViewModel: HomeActivityViewModel by viewModels()
    private lateinit var adapter:AllBreedsAdapter
    private var listDogs:MutableList<String> = mutableListOf()

    private var listBreedsNames: ArrayList<Message> = ArrayList()
    private var listBreedsNamesArray: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeBuscador()
        handleEnterEventBuscador()
        initializeObservers()
    }

    private fun initializeBuscador() {
        breedsViewModel.getAllBreedsNames()
    }

    private fun initializeObservers() {
        breedsViewModel.getBreedsByTypeLiveData.observe(this, Observer { response ->
            for (dog in response.message.indices) {
                listDogs.add(response.message[dog])
            }
            updateRecyclerView(listDogs)
        })

        breedsViewModel.isLoadingLiveData.observe(this, Observer {
            if (it == true) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }

        })

        breedsViewModel.getAllBreedsNamesLiveData.observe(this, Observer {
                listBreedsNames.addAll(listOf(it.message))
                for(pos in listBreedsNames.indices){
                    println("El nombre dentro de la lista es " + " " + listBreedsNames[pos])
                    listBreedsNamesArray.add(listBreedsNames[pos].toString())
                }

                val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,
                        R.layout.custom_list_item, R.id.text_view_list_item,listBreedsNamesArray
                )
                binding.buscador.setAdapter(adapter)
        })
    }

    private fun handleEnterEventBuscador() {
        binding.buscador.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            clearListOfRecycler()
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                breedsViewModel.getBreedsByTypeLiveData(binding.buscador.text.toString().toLowerCase())
                return@OnKeyListener true
            }
            false
        })
    }

    private fun clearListOfRecycler() {

        if (listDogs.size > 0) {
            for (i in 0 until listDogs.size) {
                listDogs.removeAt(0)
            }
            binding.recyclerBreeds.adapter!!.notifyItemRangeRemoved(0, listDogs.size)
        }
        //adapter.clearList()
        //myRecycler.adapter!!.notifyDataSetChanged()
    }

    private fun updateRecyclerView(listDogs: MutableList<String>) {
        val gridLayoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        adapter = AllBreedsAdapter(listDogs)
        binding.recyclerBreeds.layoutManager = gridLayoutManager
        binding.recyclerBreeds.setHasFixedSize(true)
        binding.recyclerBreeds.adapter = adapter
        binding.recyclerBreeds.adapter?.notifyDataSetChanged()
    }


}