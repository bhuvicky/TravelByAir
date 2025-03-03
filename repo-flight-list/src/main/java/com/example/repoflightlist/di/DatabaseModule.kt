package com.example.repoflightlist.di

import android.content.Context
import androidx.room.Room
import com.example.corecommon.util.DiskExecutor
import com.example.repoflightlist.db.FlightDao
import com.example.repoflightlist.db.FlightDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideFlightDatabase(
        @ApplicationContext context: Context,
        diskExecutor: DiskExecutor
    ): FlightDatabase {
        return Room
            .databaseBuilder(context, FlightDatabase::class.java, "flight.db")
            .setQueryExecutor(diskExecutor)
            .setTransactionExecutor(diskExecutor)
            .build()
    }

    @Provides
    fun provideFlightDao(flightDatabase: FlightDatabase): FlightDao {
        return flightDatabase.flightDao()
    }
}