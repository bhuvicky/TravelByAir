package com.example.repoflightlist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFlights(flights: FlightDbData)

    @Query("SELECT * FROM flightList")
    fun getFlights(): Flow<FlightDbData>
}