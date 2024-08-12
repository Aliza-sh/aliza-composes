package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    val filterList = listOf("All", "Flight", "Cruise", "Train", "Car", "Ship")

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(18.dp))
        HeaderWidget()
        Spacer(modifier = Modifier.height(10.dp))
        SearchWidget()
        Spacer(modifier = Modifier.height(10.dp))
        FilterWidget(filterList = filterList)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}