package com.example.featureflightbooking.model

import com.example.repoflightlist.model.FlightItem
import java.text.NumberFormat

data class FlightListUiState(
    val apiStatus: FlightApiStatus = FlightApiStatus.LOADING,
    val data: List<FlightItemUiData>? = null,
    val error: String? = null
)

data class FlightItemUiData(
    val airlineName: String,
    val originAirport: String,
    val destinationAirport: String,
    val departureTime: String,
    val arrivalTime: String,
    val price: String,
    val transfers: String,
)

enum class FlightApiStatus {
    LOADING,
    SUCCESS,
    ERROR
}

fun List<FlightItem>.toFlightItemUiState(): List<FlightItemUiData> = map {
    FlightItemUiData(
        airlineName = it.airlineCode,
        originAirport = it.origin,
        destinationAirport = it.destination,
        departureTime = "11:15",
        arrivalTime = "15:30",
        price = NumberFormat.getCurrencyInstance().format(it.price),
        transfers = if (it.transfers == 0) "Direct" else "${it.transfers} stops"
    )
}