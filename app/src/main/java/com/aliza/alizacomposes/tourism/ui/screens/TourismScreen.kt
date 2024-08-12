package com.aliza.alizacomposes.tourism.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.tourism.ui.components.BottomBar

@Composable
fun TourismScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar{
            navController.navigate(it) {
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        } }
    ) { innerPadding ->
       Navigation(navController, Modifier.padding(innerPadding))
    }
}

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {}
        composable("favorite") {}
        composable("tickets") {}
        composable("reels") {}
        composable("profile") {}
    }
}

@Preview
@Composable
fun TourismScreenPrev() {
    TourismScreen()
}