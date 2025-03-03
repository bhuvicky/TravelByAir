package com.example.travelbyair

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.featureflightbooking.ui.FlightListLayout

val LocalNavController = compositionLocalOf<NavController> {
    error("NavController not provided")
}


@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                FlightListLayout()
            }
        }
    }
}