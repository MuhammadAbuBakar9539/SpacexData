package com.example.spacexdata.model


import com.google.gson.annotations.SerializedName

data class Height(
    @SerializedName("feet")
    val feet: Double,
    @SerializedName("meters")
    val meters: Double
)