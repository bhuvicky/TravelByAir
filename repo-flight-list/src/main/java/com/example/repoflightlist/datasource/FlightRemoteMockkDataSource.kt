package com.example.repoflightlist.datasource

import com.example.repoflightlist.mockkserver.MockkApiService
import javax.inject.Inject

class FlightRemoteMockkDataSource @Inject constructor(
    private val flightApi: MockkApiService
): FlightDataSource.RemoteMockk {
    override suspend fun geMockkFlights(fileName: String) = runCatching {
        flightApi.getMockkFlights(fileName)
    }
}