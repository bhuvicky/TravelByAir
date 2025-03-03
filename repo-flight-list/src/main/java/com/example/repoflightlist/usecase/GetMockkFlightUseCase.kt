package com.example.repoflightlist.usecase

import com.example.repoflightlist.db.FlightDbData
import com.example.repoflightlist.repository.FlightRepository

class GetMockkFlightUseCase (
    private val flightRepository: FlightRepository
) {
    suspend operator fun invoke(fileName: String): Result<FlightDbData> =
        flightRepository.getMockkFlightData(fileName)
}