package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppDarkGrayAlpha
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppSilverAlpha
import kotlinx.coroutines.launch

@Composable
fun TransactionFAB(lazyListState: LazyListState) {

    val coroutineScope = rememberCoroutineScope()
    var showFAB by remember { mutableStateOf(false) }
    if (lazyListState.isScrollInProgress) {
        showFAB = lazyListState.firstVisibleItemIndex > 2
    }
    AnimatedVisibility(
        visible = showFAB,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight }, // Slide in from the bottom
            animationSpec = tween(durationMillis = 600) // Duration of the animation
        ) + fadeIn(
            animationSpec = tween(durationMillis = 600) // Fade in with the same duration
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> fullHeight }, // Slide out to the bottom
            animationSpec = tween(durationMillis = 600) // Duration of the animation
        ) + fadeOut(
            animationSpec = tween(durationMillis = 600) // Fade out with the same duration
        )
    ) {
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    lazyListState.animateScrollToItem(0)
                }
            },
            containerColor = if (isSystemInDarkTheme()) AppDarkGrayAlpha else AppSilverAlpha,
            elevation = FloatingActionButtonDefaults.elevation(0.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Up",
            )
        }
    }
}