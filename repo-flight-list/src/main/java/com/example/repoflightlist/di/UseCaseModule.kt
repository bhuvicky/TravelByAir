package com.example.repoflightlist.di

import com.example.repoflightlist.repository.FlightRepository
import com.example.repoflightlist.usecase.GetFlightsUseCase
import com.example.repoflightlist.usecase.GetMockkFlightUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetFlightsUseCase(flightRepository: FlightRepository) = GetFlightsUseCase(flightRepository)

    @Provides
    fun provideGetMockkFlightsUseCase(flightRepository: FlightRepository) = GetMockkFlightUseCase(flightRepository)
}