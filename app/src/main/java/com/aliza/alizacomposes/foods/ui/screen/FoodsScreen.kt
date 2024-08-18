package com.aliza.alizacomposes.foods.ui.screen

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.foods.ui.component.BottomBar
import com.aliza.alizacomposes.foods.ui.screen.chat.ChatScreen
import com.aliza.alizacomposes.foods.ui.screen.home.HomeScreen
import com.aliza.alizacomposes.foods.ui.utils.NavigationItem

@Composable
fun FoodsScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {}
        Navigation(navController = navController)
    }
}

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {

    val menu = listOf(
        NavigationItem.Basket,
        NavigationItem.Chat,
        NavigationItem.Home,
        NavigationItem.Explore,
        NavigationItem.Search
    )

    // Variable to hold the previous and current route
    var previousRoute by remember { mutableStateOf<String?>(null) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute = currentBackStackEntry?.destination?.route

    // Detect changes in the current route
    LaunchedEffect(currentRoute) {
        if (currentRoute != null && currentRoute != previousRoute) {
            // Here you can do something with the previous and current route
            println("Previous Route: $previousRoute, Current Route: $currentRoute")
            Log.e("TAGsd", "Previous Route: $previousRoute, Current Route: $currentRoute")
            previousRoute = currentRoute // Update the previous route
        }
    }

    var previousId = menu.find { it.route == previousRoute }?.id
    var currentId = menu.find { it.route == currentRoute }?.id

    if (previousRoute == "home" && currentId != null) {
        previousId = 3
        if (currentId.toInt() >= 3)
            currentId -= 1
        else
            currentId += 1
    }
    if (currentRoute == "home" && previousId != null) {
        currentId = 3
        if (previousId.toInt() >= 3)
            previousId -= 1
        else
            previousId += 1
    }

    Log.e("TAGsd", "Previous ID: $previousId, Current Id: $currentId")


    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = {
            if (previousId != null) {
                if (previousId < currentId!!) {
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
                if (previousId < currentId!!) {
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
        composable("basket") {}
        composable("chat") {
            ChatScreen()
        }
        composable("explore") {}
        composable("search") {}
    }
}

@Preview
@Composable
private fun FoodsScreenPrev() {
    FoodsScreen()
}