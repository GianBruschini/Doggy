package com.gian.doggy.data.network

import com.gian.doggy.core.RetrofitHelper
import com.gian.doggy.data.model.BreedResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.util.*

class BreedService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllBreeds():BreedResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(BreedApiClient::class.java).getAllBreeds()
            response.body()!!
        }


    }
}