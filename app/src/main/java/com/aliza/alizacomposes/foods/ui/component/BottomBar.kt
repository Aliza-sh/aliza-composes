package com.aliza.alizacomposes.foods.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppDarkGray
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppLightGray
import com.aliza.alizacomposes.foods.ui.utils.BottomNavCurve
import com.aliza.alizacomposes.foods.ui.utils.NavigationItem

@Composable
fun BottomBar(navController: NavHostController) {

    val menu = listOf(
        NavigationItem.Basket,
        NavigationItem.Chat,
        NavigationItem.Home,
        NavigationItem.Explore,
        NavigationItem.Search
    )

    val navColor = if (isSystemInDarkTheme()) AppDark else AppLight

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1F)
            .height(118.dp)
            .clip(BottomNavCurve())
            .background(navColor)
            .padding(horizontal = 12.dp)
    ) {
        ItemNavBar(menu) { navTo ->
            navController.navigate(navTo) {
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
}

@Composable
fun ItemNavBar(menu: List<NavigationItem>, navTo: (String) -> Unit) {

    var selectedRoute by remember { mutableStateOf("home") }

    menu.forEachIndexed { index, navigationItem ->

        val backgroundHome = if (isSystemInDarkTheme()) Color.Black else Color.White

        val selectColor = if (isSystemInDarkTheme()) AppLightGray else Color.Black
        val unSelectColor = if (isSystemInDarkTheme()) AppDarkGray else AppLightGray
        val selectedColor =
            if (selectedRoute == navigationItem.route) selectColor else unSelectColor

        if (index == 2) {
            IconButton(
                onClick = {
                    selectedRoute = navigationItem.route

                    navTo(navigationItem.route)
                },
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
                    .background(backgroundHome, CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = navigationItem.icon),
                    contentDescription = navigationItem.title,
                    tint = selectedColor,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(8.dp)
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable {
                        selectedRoute = navigationItem.route

                        navTo(navigationItem.route)
                    }
                    .background(Color.Transparent, RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = navigationItem.icon),
                    contentDescription = navigationItem.title,
                    tint = selectedColor,
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .size(40.dp)
                        .padding(8.dp)
                )
                Text(
                    text = navigationItem.title,
                    color = selectedColor,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W100,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun BottomBarPrev() {
    BottomBar(rememberNavController())
}