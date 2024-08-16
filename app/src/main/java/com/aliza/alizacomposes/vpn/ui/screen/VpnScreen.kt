package com.aliza.alizacomposes.vpn.ui.screen

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
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
import com.aliza.alizacomposes.vpn.ui.screen.login.LoginScreen

@Composable
fun VpnScreen() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Navigation(navController = navController)
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { +1000 },
                animationSpec = tween(700)
            ) + fadeIn(
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(700)
            ) + fadeOut(
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(700)
            ) + fadeIn(
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { +1000 },
                animationSpec = tween(700)
            ) + fadeOut(
                animationSpec = tween(700)
            )
        }
    ) {
        composable("login") {
            LoginScreen(navController)
        }
    }
}

@Preview
@Composable
fun VpnScreenPrev() {
    VpnScreen()
}