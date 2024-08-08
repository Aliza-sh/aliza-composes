package com.aliza.alizacomposes.instagram.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aliza.alizacomposes.instagram.ui.theme.GrayLite
import com.aliza.alizacomposes.instagram.ui.utils.NavigationItem

@Composable
fun BottomBar(navController: NavHostController) {

    val menu = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Add,
        NavigationItem.Reels,
        NavigationItem.Profile
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 16.dp, end = 8.dp)
    ) {
        ItemNavBar(menu, navController)

    }
}

@Composable
fun ItemNavBar(menu: List<NavigationItem>, navController: NavHostController) {
    var selectedRoute by remember { mutableStateOf("home") }


    menu.forEach { navigationItem ->
        val backgroundColor =
            if (selectedRoute == navigationItem.route) GrayLite else Color.Transparent

        IconButton(
            onClick = {
                navController.navigate(navigationItem.route) {
                    selectedRoute = navigationItem.route
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            Icon(
                painter = painterResource(id = navigationItem.icon),
                contentDescription = navigationItem.title,
                tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(8.dp)
            )
            Box( modifier = Modifier
                .height(26.dp)
                .width(100.dp)
                .background(backgroundColor, RoundedCornerShape(50))
            )
        }
    }
}