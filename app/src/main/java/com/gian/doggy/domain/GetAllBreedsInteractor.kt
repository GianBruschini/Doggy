package com.gian.doggy.domain

import com.gian.doggy.data.BreedRepository
import com.gian.doggy.data.model.BreedResponse

class GetAllBreedsInteractor {
    private val respository = BreedRepository()

    suspend operator fun invoke(breedType:String):BreedResponse{
        return respository.getBreedsByType(breedType)
    }
}