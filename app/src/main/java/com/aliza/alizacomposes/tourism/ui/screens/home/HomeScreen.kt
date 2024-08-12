package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.tourism.model.TouristArea

@Composable
fun HomeScreen() {

    val filterList = listOf("All", "Flight", "Cruise", "Train", "Car", "Ship")
    val touristAreas = listOf(
        TouristArea("Paris", 120, R.drawable.paris),
        TouristArea("Rome", 150, R.drawable.rome),
        TouristArea("Tehran", 240, R.drawable.tehran),
        TouristArea("Spain", 180, R.drawable.spain),
        TouristArea("Bali", 170, R.drawable.bali),
        TouristArea("Hawaii", 250, R.drawable.hawaii)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(18.dp))
        HeaderWidget()
        Spacer(modifier = Modifier.height(10.dp))
        SearchWidget()
        Spacer(modifier = Modifier.height(10.dp))
        FilterWidget(filterList = filterList)
        TouristAreasGridWidget(touristAreas = touristAreas)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}