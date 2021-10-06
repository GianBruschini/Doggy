package com.gian.doggy.data

import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.network.BreedService

class BreedRepository {
    private val api = BreedService()

    suspend fun getAllBreeds():BreedResponse{
        val response = api.getAllBreeds()
        return response
    }
}