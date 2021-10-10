package com.gian.doggy.data.model

import com.google.gson.annotations.SerializedName

data class BreedsNamesResponse(@SerializedName("message") val message : Message,
                               @SerializedName("status") val status : String) {
}