package com.gian.doggy.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.model.BreedsNamesResponse
import com.gian.doggy.domain.GetAllBreedsInteractor
import com.gian.doggy.domain.GetAllBreedsNamesInteractor
import kotlinx.coroutines.launch

class HomeActivityViewModel: ViewModel() {
    val getBreedsByTypeLiveData = MutableLiveData<BreedResponse>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
    var getAllBreedsInteractor = GetAllBreedsInteractor()
    val getAllBreedsNamesInteractor = GetAllBreedsNamesInteractor()
    val getAllBreedsNamesLiveData = MutableLiveData<BreedsNamesResponse>()


    /*fun onCreate(){
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            val result = getAllBreedsInteractor()
            if(result != null){
                getAllBreedsLiveData.postValue(result)
                isLoadingLiveData.postValue(false)
            }
        }
    }

     */

    fun getBreedsByTypeLiveData(breedType:String){

        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            val resultQuery = getAllBreedsInteractor(breedType)
            if(resultQuery != null){
                getBreedsByTypeLiveData.postValue(resultQuery)
                isLoadingLiveData.postValue(false)
            }
        }
    }

    fun getAllBreedsNames(){
        viewModelScope.launch {
            val resultQuery = getAllBreedsNamesInteractor()
            getAllBreedsNamesLiveData.postValue(resultQuery)
        }
    }
}