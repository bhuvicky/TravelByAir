package com.example.repoflightlist.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.repoflightlist.model.FlightItem
import com.example.repoflightlist.roomutils.FlightConverters

@Entity(tableName = "flightList")
@TypeConverters(FlightConverters::class)
data class FlightDbData(
    @PrimaryKey val id: Int = 0,
    val data: List<FlightItem>,
    val currency: String,
    val success: Boolean,
    val ttl: Long = 0
)

