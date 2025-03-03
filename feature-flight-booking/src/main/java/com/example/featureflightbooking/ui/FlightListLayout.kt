package com.example.featureflightbooking.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.featureflightbooking.R
import com.example.featureflightbooking.model.FlightItemUiData
import com.example.featureflightbooking.viewmodel.FlightListViewModel


@Composable
fun FlightListLayout() {
    val viewModel = hiltViewModel<FlightListViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    FlightListLayout(
        uiState.value.data,
        viewModel::makeApiCall
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FlightListLayout(
    flightData: List<FlightItemUiData>?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
//    val navController = LocalNavController.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { /*navController.popBackStack()*/ }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.fillMaxWidth()
                .padding(16.dp),
            contentPadding = paddingValues
        ) {
            items(flightData ?: emptyList()) { flightItem ->
                FlightCard(flightItem, onClick)
            }
        }
    }
}
