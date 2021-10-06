package com.gian.doggy.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.domain.GetAllBreedsInteractor
import kotlinx.coroutines.launch

class HomeActivityViewModel: ViewModel() {
    val getAllBreedsLiveData = MutableLiveData<BreedResponse>()
    val isLoadingLiveData = MutableLiveData<Boolean>()
    var getAllBreedsInteractor = GetAllBreedsInteractor()


    fun onCreate(){
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            val result = getAllBreedsInteractor()
            if(result != null){
                getAllBreedsLiveData.postValue(result)
                isLoadingLiveData.postValue(false)
            }
        }
    }
}