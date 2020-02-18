package com.example.spacexdata.model


import com.google.gson.annotations.SerializedName

data class ThrustVacuumX(
    @SerializedName("kN")
    val kN: Int,
    @SerializedName("lbf")
    val lbf: Int
)