package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.movies.ui.theme.AppLightGray
import com.aliza.alizacomposes.movies.ui.theme.AppMenuGray
import com.aliza.alizacomposes.movies.ui.theme.AppRed
import com.aliza.alizacomposes.movies.ui.utils.NavigationItem

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    val menus = listOf(
        NavigationItem.Home,
        NavigationItem.Movie,
        NavigationItem.Favorites,
        NavigationItem.Profile
    )
    var selectedMenu by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50, 50))
            .background(AppLightGray)
            .height(80.dp)
            .padding(25.dp, 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(menus.size) { index ->
            val menu = menus[index]
            Row(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50.dp))
                    .background(if (selectedMenu == index) AppRed else Color.Transparent)
                    .padding(10.dp)
                    .animateContentSize()
                    .clickable { selectedMenu = index },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = menu.icon),
                    contentDescription = menu.title,
                    tint = if (selectedMenu == index) Color.White else AppMenuGray,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                AnimatedVisibility(
                    visible = selectedMenu == index,
                    enter = fadeIn(animationSpec = tween(durationMillis = 1500)) +
                            expandHorizontally(animationSpec = tween(durationMillis = 100)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 0)) +
                            shrinkHorizontally(animationSpec = tween(durationMillis = 100))
                ) {
                    Text(
                        text = menu.title,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun BottomBarPrev() {
    BottomBar()
}