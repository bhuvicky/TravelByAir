package com.example.repoflightlist.mockkserver

import android.content.Context
import com.example.repoflightlist.IoDispatcher
import com.example.repoflightlist.model.FlightData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MockkServer @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): MockkApiService {

    override suspend fun getMockkFlights(fileName: String): FlightData = withContext(dispatcher) {
        val jsonString = readFile(fileName)
        Gson().fromJson(jsonString, FlightData::class.java)
    }

    private suspend fun readFile(fileName: String): String = withContext(dispatcher) {
        applicationContext.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}