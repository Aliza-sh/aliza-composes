package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.instagram.model.Story
import com.aliza.alizacomposes.instagram.ui.theme.GrayLite
import kotlinx.coroutines.launch

@Composable
internal fun StoryLiveWidget(story: Story) {
    // Create animatable values for image and background scales
    val imageScale = remember { androidx.compose.animation.core.Animatable(1f) }
    val backgroundScale = remember { androidx.compose.animation.core.Animatable(0.5f) }

    // Launch the animation when the Composable enters the composition
    LaunchedEffect(Unit) {
        launch {
            while (true) {
                imageScale.animateTo(
                    targetValue = 0.65f,
                    animationSpec = tween(durationMillis = 500)
                )
                imageScale.animateTo(
                    targetValue = 0.7f,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        }
        launch {
            while (true) {
                backgroundScale.animateTo(
                    targetValue = 0.55f,
                    animationSpec = tween(durationMillis = 500)
                )
                backgroundScale.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .size(86.dp)
            .padding(6.dp)
            .border(1.dp, GrayLite, CircleShape)
            .background(
                Brush.radialGradient(
                    listOf(Color.Transparent, GrayLite),
                ),
                CircleShape
            )
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        // Background box that scales up and down
        Spacer(
            modifier = Modifier
                .size((76 * backgroundScale.value).dp)
                .background(
                    Brush.radialGradient(
                        listOf(Color.Transparent, GrayLite),
                    ),
                    CircleShape
                )
                .clip(CircleShape)
        )

        // Image that scales down and up
        Image(
            painter = painterResource(id = story.profile), // Replace with your image
            contentDescription = null,
            modifier = Modifier
                .size((100 * imageScale.value).dp)
                .padding(8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}