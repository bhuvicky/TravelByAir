package com.example.featureflightbooking.viewmodel

import com.example.repoflightlist.usecase.GetFlightsUseCase
import org.junit.Assert.*
import org.junit.Before

class FlightListViewModelTest {
    private val getFlightsUseCase: GetFlightsUseCase = mockk()

    private val subject by lazy {
        FlightListViewModel(getFlightsUseCase)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        every { getFlightsUseCase(any()) } returns Result.success(FlightDbData())
    }

    fun testGetFlightList() {
        val flightList = viewModel.getFlightList()
        assertNotNull(flightList)
    }
}