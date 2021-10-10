package com.gian.doggy.data

import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.model.BreedsNamesResponse
import com.gian.doggy.data.network.BreedService

class BreedRepository {
    private val api = BreedService()

    suspend fun getBreedsByType(breedType:String):BreedResponse{
        val response = api.getBreedsByType(breedType)
        return response
    }

    suspend fun getBreedsNames(): BreedsNamesResponse {
        val response = api.getBreedsNames()
        return response
    }
}