package com.example.spacexdata.network

import com.example.spacexdata.common.END_POINT
import com.example.spacexdata.model.SpacexDataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Client {

    @GET(END_POINT)
    fun getSpacexData(): Observable<List<SpacexDataResponse>>

}