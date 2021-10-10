package com.gian.doggy.data.network

import com.gian.doggy.core.RetrofitHelper
import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.model.BreedsNamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.util.*

class BreedService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBreedsByType(breedType:String):BreedResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(BreedApiClient::class.java).getBreedsByType(breedType)

            response.body()!!
        }

    }


    suspend fun getBreedsNames(): BreedsNamesResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(BreedApiClient::class.java).getBreedsNames()

            response.body()!!
        }
    }
}