package com.aliza.alizacomposes.vpn.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.vpn.ui.theme.Black
import com.aliza.alizacomposes.vpn.ui.theme.NavyBlue

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Black, NavyBlue)))
    ) {

    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen(rememberNavController())
}