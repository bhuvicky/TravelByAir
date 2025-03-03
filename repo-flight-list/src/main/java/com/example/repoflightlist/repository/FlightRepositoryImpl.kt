package com.example.repoflightlist.repository

import com.example.repoflightlist.datasource.FlightDataSource
import com.example.repoflightlist.db.FlightDbData
import com.example.repoflightlist.model.toDbData
import javax.inject.Inject

class FlightRepositoryImpl @Inject constructor(
    private val local: FlightDataSource.Local,
    private val remote: FlightDataSource.Remote,
    private val remoteMockk: FlightDataSource.RemoteMockk
): FlightRepository {

    override suspend fun getFlights(queryParams: Map<String, String>): Result<FlightDbData> {
        return runCatching {
            local.getFlights().getOrThrow()
        }.recoverCatching {
            val flights = remote.getFlights(queryParams).getOrThrow()
            local.saveFlights(flights)
            flights.toDbData()
        }
    }

    override suspend fun getMockkFlightData(fileName: String): Result<FlightDbData> {
        return runCatching {
            local.getFlights().getOrThrow()
        }.recoverCatching {
            val flights = remoteMockk.geMockkFlights(fileName).getOrThrow()
            local.saveFlights(flights)
            flights.toDbData()
        }
    }
}