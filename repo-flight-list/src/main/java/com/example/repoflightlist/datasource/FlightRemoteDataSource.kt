package com.example.repoflightlist.datasource

import com.example.repoflightlist.FlightApiService
import javax.inject.Inject

class FlightRemoteDataSource @Inject constructor(
    private val flightApi: FlightApiService
): FlightDataSource.Remote {
    override suspend fun getFlights(params: Map<String, String>) = runCatching {
        flightApi.getFlights(params)
    }
}