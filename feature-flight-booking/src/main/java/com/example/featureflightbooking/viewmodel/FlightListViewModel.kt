package com.example.featureflightbooking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featureflightbooking.BuildConfig
import com.example.featureflightbooking.model.FlightApiStatus
import com.example.featureflightbooking.model.FlightListUiState
import com.example.featureflightbooking.model.toFlightItemUiState
import com.example.repoflightlist.usecase.GetFlightsUseCase
import com.example.repoflightlist.usecase.GetMockkFlightUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlightListViewModel @Inject constructor(
    private val getFlightsUseCase: GetFlightsUseCase,
    private val getMockkFlightUseCase: GetMockkFlightUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<FlightListUiState> = MutableStateFlow(FlightListUiState())
    val uiState = _uiState.asStateFlow()

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(apiStatus = FlightApiStatus.LOADING) }
            getFlightsUseCase(
                mutableMapOf(
                    "origin" to "MAA",
                    "destination" to "DEL",
                    "departure_at" to "2025-04",
                    "sorting" to "price",
                    "currency" to "INR",
                    "page" to "1",
                    "token" to BuildConfig.API_KEY
                )
            ).fold(
                onSuccess = { flights ->
                    _uiState.update { it.copy(data = flights.data.toFlightItemUiState()) }
                },
                onFailure = { throwable ->
                    throwable.printStackTrace()
                    _uiState.update { it.copy(error = throwable.message) }
                }
            )
        }
    }

    private fun makeMockkApiCall() {
        viewModelScope.launch {
            getMockkFlightUseCase("flight_list.json").fold(
                onSuccess = { flights ->
//                    _uiState.value = FlightListUiState(false)
                },
                onFailure = { throwable ->
                    throwable.printStackTrace()
//                    _uiState.value = FlightListUiState(false)
                }
            )
        }
    }
}