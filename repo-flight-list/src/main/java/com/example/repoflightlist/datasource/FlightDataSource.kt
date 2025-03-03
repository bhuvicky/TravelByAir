package com.example.repoflightlist.datasource

import com.example.repoflightlist.db.FlightDbData
import com.example.repoflightlist.model.FlightData

interface FlightDataSource {

    interface Remote {
        suspend fun getFlights(params: Map<String, String>): Result<FlightData>
    }

    interface RemoteMockk {
        suspend fun geMockkFlights(fileName: String): Result<FlightData>
    }

    interface Local {
        suspend fun getFlights(): Result<FlightDbData>
        suspend fun saveFlights(flights: FlightData)
    }
}