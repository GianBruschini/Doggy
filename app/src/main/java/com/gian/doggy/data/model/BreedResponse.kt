package com.gian.doggy.data.model

import com.google.gson.annotations.SerializedName

data class BreedResponse(@SerializedName("message") val message : List<String>,
                         @SerializedName("status") val status : String)
