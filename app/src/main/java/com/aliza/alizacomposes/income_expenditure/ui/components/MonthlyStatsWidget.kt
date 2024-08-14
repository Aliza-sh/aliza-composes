package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppPurple
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppSilverAlpha
import com.aliza.alizacomposes.income_expenditure.ui.theme.Purple80

@Composable
fun MonthlyStatsWidget() {
    val colorTheme = if (isSystemInDarkTheme()) AppPurple else Color.White
    Row(
        Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(if (isSystemInDarkTheme()) Purple80 else AppPurple)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { 20f / 100f },
                modifier = Modifier
                    .size(75.dp)
                    .graphicsLayer { rotationY = 180f },
                trackColor = AppSilverAlpha,
                color = colorTheme,
                strokeWidth = 6.dp,
            )
            Text(
                text = "20%",
                color = colorTheme,
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = "Monthly Stats",
                color = colorTheme,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "+20 better performance",
                color = colorTheme,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun MonthlyStatsWidgetPrev(modifier: Modifier = Modifier) {
    MonthlyStatsWidget()
}