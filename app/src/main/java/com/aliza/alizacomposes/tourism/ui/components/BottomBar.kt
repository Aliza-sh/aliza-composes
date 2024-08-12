package com.aliza.alizacomposes.tourism.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.tourism.ui.theme.AppMenuGray
import com.aliza.alizacomposes.tourism.ui.theme.AppRed
import com.aliza.alizacomposes.tourism.ui.theme.ColorRippleDark
import com.aliza.alizacomposes.tourism.ui.theme.ColorRippleLight
import com.aliza.alizacomposes.tourism.utils.NavigationItem

@Composable
fun BottomBar(onNavItemClick: (String) -> Unit) {

    val menu = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Tickets,
        NavigationItem.Profile
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 16.dp, top = 4.dp, end = 8.dp)
    ) {
        ItemNavBar(menu) { onNavItemClick(it) }

    }
}

@Composable
fun ItemNavBar(menu: List<NavigationItem>, onNavItemClick: (String) -> Unit) {

    var selectedRoute by remember { mutableStateOf("home") }

    menu.forEach { navigationItem ->

        // Create an interaction source to handle ripple interactions
        val interactionSource = remember { MutableInteractionSource() }
        // Customize the ripple effect
        val rippleIndication = rememberRipple(
            // If true, the ripple will be bounded within the component's bounds.
            bounded = true,
            // Change the ripple color
            color = if (isSystemInDarkTheme()) ColorRippleDark else ColorRippleLight,
            // Set the radius of the ripple
            radius = 36.dp
        )

        val itemColor =
            if (selectedRoute == navigationItem.route) AppRed else AppMenuGray

        Column(
            modifier = Modifier
                .size(width = 60.dp, height = 50.dp)
                .indication(interactionSource, rippleIndication)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null // Use null if you don't want the default ripple
                ) {
                    onNavItemClick(navigationItem.route)
                    selectedRoute = navigationItem.route
                }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    painter = painterResource(id = navigationItem.icon),
                    contentDescription = navigationItem.title,
                    tint = itemColor,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp)
                        .align(Alignment.TopCenter)
                )
                this@Column.AnimatedVisibility(
                    visible = selectedRoute == navigationItem.route,
                    enter = slideInVertically(
                        initialOffsetY = { fullHeight -> fullHeight }, // Slide in from the bottom
                        animationSpec = tween(durationMillis = 300) // Duration of the animation
                    ),
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text(
                        text = navigationItem.title,
                        color = itemColor,
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 24.sp,
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPrev() {
    val onNavItemClick: ((String) -> Unit)? = null
    BottomBar() { onNavItemClick?.invoke(it) }
}