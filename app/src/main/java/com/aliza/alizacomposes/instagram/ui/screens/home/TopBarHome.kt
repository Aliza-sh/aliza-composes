package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome(scrollBehavior: TopAppBarScrollBehavior) {

    val alpha by animateFloatAsState(
        targetValue = 1f - scrollBehavior.state.collapsedFraction,
        label = ""
    )

    Column {
        TopAppBar(
            title = {
                Title(alpha)
            },
            scrollBehavior = scrollBehavior,
            actions = {
                ActionMassage(alpha)
            }
        )

        if (scrollBehavior.state.collapsedFraction > 0.01f) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.2.dp)
                    .background(Color.DarkGray)
            )
        }
    }
}

@Composable
fun Title(alpha: Float) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )
    Text(
        text = "Instagram",
        color = color,
        modifier = Modifier.graphicsLayer(alpha = alpha),
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.W900,
            fontSize = 36.sp,
        )
    )
}

@Composable
fun ActionMassage(alpha: Float) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(48.dp)
            .graphicsLayer(alpha = alpha)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Icon(
                painterResource(id = R.drawable.ic_send),
                contentDescription = "Messages",
                modifier = Modifier
                    .padding(top = 4.dp, end = 4.dp)
                    .size(24.dp),
                tint = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
            Text(
                text = "+9",
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Red, RoundedCornerShape(50))
                    .size(16.dp)
                    .fillMaxSize(),
            )
        }
    }
}