package com.gian.doggy.data.network

import com.gian.doggy.data.model.BreedResponse
import retrofit2.Response
import retrofit2.http.GET

interface BreedApiClient {
    @GET("/breeds/list/all")
    suspend fun getAllBreeds():Response<BreedResponse>
}