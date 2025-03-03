package com.example.repoflightlist.usecase

import com.example.repoflightlist.db.FlightDbData
import com.example.repoflightlist.repository.FlightRepository

class GetFlightsUseCase (
    private val flightRepository: FlightRepository
) {
    suspend operator fun invoke(queryParams: Map<String, String>): Result<FlightDbData> =
        flightRepository.getFlights(queryParams)
}