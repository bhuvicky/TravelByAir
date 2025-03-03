package com.example.repoflightlist.repository

import com.example.repoflightlist.db.FlightDbData

interface FlightRepository {
    suspend fun getFlights(queryParams: Map<String, String>): Result<FlightDbData>
    suspend fun getMockkFlightData(fileName: String): Result<FlightDbData>
}