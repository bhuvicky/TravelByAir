package com.example.featureflightbooking.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.featureflightbooking.R
import com.example.featureflightbooking.model.FlightItemUiData

@Composable
fun FlightCard(
    flightData: FlightItemUiData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        CardContent(flightData)
    }
}

@Composable
private fun CardContent(flightData: FlightItemUiData) {
    ConstraintLayout {
        val (airlineName, airlineLogo, originDestinationAirport,
            departureArrivalTime, price, transfers) = createRefs()

        Text(
            text = flightData.airlineName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(airlineName) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top, 16.dp)
            }
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_airline_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .constrainAs(airlineLogo) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(airlineName.bottom, 16.dp)
                }
        )

        Text(
            text = "${flightData.departureTime} - ${flightData.arrivalTime}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(departureArrivalTime) {
                start.linkTo(airlineLogo.end, 16.dp)
                top.linkTo(airlineName.bottom, 16.dp)
            }
        )

        Text(
            text = "${flightData.originAirport} - ${flightData.destinationAirport}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.constrainAs(originDestinationAirport) {
                start.linkTo(airlineLogo.end, 16.dp)
                top.linkTo(departureArrivalTime.bottom, 16.dp)
            }
        )

        Text(
            text = flightData.transfers,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(transfers) {
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top, 16.dp)
            }
        )

        Text(
            text = flightData.price,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            modifier = Modifier.constrainAs(price) {
                end.linkTo(parent.end, 16.dp)
                bottom.linkTo(parent.bottom, 16.dp)
            }
        )
    }
}