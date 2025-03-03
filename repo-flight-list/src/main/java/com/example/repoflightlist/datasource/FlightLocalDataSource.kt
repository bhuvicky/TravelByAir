package com.example.repoflightlist.datasource

import com.example.repoflightlist.db.FlightDao
import com.example.repoflightlist.db.FlightDbData
import com.example.corecommon.exception.CacheInvalidException
import com.example.corecommon.exception.DataNotAvailableException
import com.example.repoflightlist.model.FlightData
import com.example.repoflightlist.model.toDbData
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class FlightLocalDataSource @Inject constructor(
    private val flightDao: FlightDao
): FlightDataSource.Local {

    override suspend fun getFlights(): Result<FlightDbData> =
        runCatching {
            flightDao.getFlights().first()
        }.mapCatching { flights ->
            when {
                flights.data.isEmpty() -> throw DataNotAvailableException()
                isCacheInvalid(flights.ttl) -> throw CacheInvalidException()
                else -> flights
            }
        }

    override suspend fun saveFlights(flights: FlightData) {
        flightDao.saveFlights(flights.toDbData())
    }

    private fun isCacheInvalid(lastUpdate: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime - lastUpdate > CACHE_DURATION
    }

    companion object {
        private const val CACHE_DURATION = 5 * 60 * 1000
    }
}