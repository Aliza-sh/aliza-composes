package com.aliza.alizacomposes.movies.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.movies.model.Slider
import com.aliza.alizacomposes.movies.ui.theme.AppDark
import com.aliza.alizacomposes.movies.ui.theme.AppLightGray
import com.aliza.alizacomposes.movies.ui.theme.AppRed

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderSlider(sliderList: List<Slider>) {
    val sliderHeight = 340.dp
    val pagerState = rememberPagerState(pageCount = { sliderList.size })
    Box {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(sliderHeight)
        ) { page ->
            Image(
                painter = painterResource(id = sliderList[page].image),
                contentDescription = "Slider",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(sliderHeight)
                .background(Brush.verticalGradient(listOf(Color.Transparent, AppDark)))
                .align(Alignment.BottomCenter)
        )
        PagerIndicator(
            pageCount = pagerState.pageCount,
            currentPage = pagerState.currentPage,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    indicatorSize: Dp = 12.dp,
    selectedIndicatorSize: Dp = 24.dp,
    spacing: Dp = 8.dp,
    activeColor: Color = AppRed,
    inactiveColor: Color = AppLightGray,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 16.dp)
            .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (pageIndex in 0 until pageCount) {
            val isSelected = pageIndex == currentPage

            val size by animateDpAsState(
                targetValue = if (isSelected) selectedIndicatorSize else indicatorSize,
                animationSpec = tween(durationMillis = 300), label = ""
            )

            val color by animateColorAsState(
                targetValue = if (isSelected) activeColor else inactiveColor,
                animationSpec = tween(durationMillis = 300), label = ""
            )

            Box(
                modifier = Modifier
                    .size(size,8.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}
