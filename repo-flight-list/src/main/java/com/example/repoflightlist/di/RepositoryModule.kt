package com.example.repoflightlist.di

import com.example.repoflightlist.datasource.FlightDataSource
import com.example.repoflightlist.datasource.FlightLocalDataSource
import com.example.repoflightlist.datasource.FlightRemoteDataSource
import com.example.repoflightlist.datasource.FlightRemoteMockkDataSource
import com.example.repoflightlist.mockkserver.MockkApiService
import com.example.repoflightlist.mockkserver.MockkServer
import com.example.repoflightlist.repository.FlightRepository
import com.example.repoflightlist.repository.FlightRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsFlightRepository(flightRepositoryImpl: FlightRepositoryImpl): FlightRepository

    @Binds
    abstract fun bindsFlightLocalDataSource(flightLocalDataSource: FlightLocalDataSource): FlightDataSource.Local

    @Binds
    abstract fun bindsFlightRemoteDataSource(flightRemoteDataSource: FlightRemoteDataSource): FlightDataSource.Remote

    @Binds
    abstract fun bindsFlightRemoteMockkDataSource(flightRemoteMockkDataSource: FlightRemoteMockkDataSource): FlightDataSource.RemoteMockk

    @Binds
    abstract fun bindsFlightMockkServer(flightMockkServer: MockkServer): MockkApiService
}