package com.gian.doggy.data.network

import com.gian.doggy.data.model.BreedResponse
import com.gian.doggy.data.model.BreedsNamesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedApiClient {
    @GET("breeds/list/all")
    suspend fun getBreedsNames():Response<BreedsNamesResponse>


    @GET("breed/{breed_type}/images")
    suspend fun getBreedsByType(@Path("breed_type") breed_type: String): Response<BreedResponse>
}