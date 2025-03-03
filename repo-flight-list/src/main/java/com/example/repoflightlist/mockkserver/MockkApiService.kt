package com.example.repoflightlist.mockkserver

import com.example.repoflightlist.model.FlightData

interface MockkApiService {

    suspend fun getMockkFlights(fileName: String): FlightData
}