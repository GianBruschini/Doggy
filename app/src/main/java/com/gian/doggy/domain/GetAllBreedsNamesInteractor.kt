package com.gian.doggy.domain

import com.gian.doggy.data.BreedRepository
import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.model.BreedsNamesResponse

class GetAllBreedsNamesInteractor {
    private val respository = BreedRepository()

    suspend operator fun invoke(): BreedsNamesResponse {

        return respository.getBreedsNames()
    }
}