package com.example.repoflightlist.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FlightDbData::class],
    version = 1,
    exportSchema = false
)
abstract class FlightDatabase: RoomDatabase() {
    abstract fun flightDao(): FlightDao
}