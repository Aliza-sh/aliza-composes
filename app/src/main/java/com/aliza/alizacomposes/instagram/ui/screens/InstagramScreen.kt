package com.aliza.alizacomposes.instagram.ui.screens

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.instagram.ui.components.BottomBar
import com.aliza.alizacomposes.instagram.ui.screens.addpost.AddPostScreen
import com.aliza.alizacomposes.instagram.ui.screens.home.HomeScreen
import com.aliza.alizacomposes.instagram.ui.screens.reels.ReelsScreen
import com.aliza.alizacomposes.instagram.ui.screens.search.SearchScreen
import com.aliza.alizacomposes.instagram.ui.utils.NavigationItem
import com.aliza.alizacomposes.instagram.ui.screens.profile.ProfileScreen

@Preview
@Composable
fun InstagramScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp)
                .background(Color.Black)
        )
        Navigation(navController, Modifier.padding(it))
    }
}

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {

    val menu = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Add,
        NavigationItem.Reels,
        NavigationItem.Profile
    )

    // Variable to hold the previous and current route
    var previousRoute by remember { mutableStateOf<String?>(null) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    // Detect changes in the current route
    LaunchedEffect(currentRoute) {
        if (currentRoute != null && currentRoute != previousRoute) {
            // Here you can do something with the previous and current route
            println("Previous Route: $previousRoute, Current Route: $currentRoute")
            Log.e("TAGsd", "Previous Route: $previousRoute, Current Route: $currentRoute")
            previousRoute = currentRoute // Update the previous route
        }
    }

    val previousId = menu.find { it.route == previousRoute }
    val currentId = menu.find { it.route == currentRoute }
    Log.e("TAGsd", "Previous ID: ${previousId?.id}, Current Id: ${currentId?.id}")

    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = {
            if (previousId != null) {
                if (previousId.id < currentId?.id!!) {
                    slideInHorizontally(
                        initialOffsetX = { 1000 },
                        animationSpec = tween(700)
                    ) + fadeIn(
                        animationSpec = tween(700)
                    )
                } else {
                    slideInHorizontally(
                        initialOffsetX = { -1000 },
                        animationSpec = tween(700)
                    ) + fadeIn(
                        animationSpec = tween(700)
                    )
                }
            } else
                slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(700)
                ) + fadeIn(
                    animationSpec = tween(700)
                )

        },
        exitTransition = {
            if (previousId != null) {
                if (previousId.id < currentId?.id!!) {
                    slideOutHorizontally(
                        targetOffsetX = { -1000 },
                        animationSpec = tween(700)
                    ) + fadeOut(
                        animationSpec = tween(700)
                    )
                } else {
                    slideOutHorizontally(
                        targetOffsetX = { 1000 },
                        animationSpec = tween(700)
                    ) + fadeOut(
                        animationSpec = tween(700)
                    )
                }
            } else
                slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(700)
                ) + fadeOut(
                    animationSpec = tween(700)
                )
        }
    ) {
        composable("home") {
            HomeScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("add") {
            AddPostScreen()
        }
        composable("reels") {
            ReelsScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}