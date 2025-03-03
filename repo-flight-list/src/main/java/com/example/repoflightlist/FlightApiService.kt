package com.example.repoflightlist

import com.example.repoflightlist.model.FlightData
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FlightApiService {

    @GET("prices_for_dates")
    suspend fun getFlights(@QueryMap params: Map<String, String>): FlightData
}