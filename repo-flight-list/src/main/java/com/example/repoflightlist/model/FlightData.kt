package com.example.repoflightlist.model

import com.example.repoflightlist.db.FlightDbData
import com.google.gson.annotations.SerializedName

data class FlightData(
    val data: List<FlightItem>,
    val currency: String,
    val success: Boolean
)

data class FlightItem(
    @SerializedName("flight_number") val flightNumber: String,
    @SerializedName("airline") val airlineCode: String,
    val origin: String,
    val destination: String,
    val price: Double,
    @SerializedName("departure_at") val departAt: String,
    @SerializedName("return_at") val returnAt: String,
    val transfers: Int,
    @SerializedName("return_transfers") val returnTransfers: Int,
    @SerializedName("duration_to") val durationTo: Int,
    @SerializedName("duration_back") val durationBack: Int
)

fun FlightData.toDbData() = FlightDbData(
    data = data,
    currency = currency,
    success = success,
    ttl = System.currentTimeMillis()
)