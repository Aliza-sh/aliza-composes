package com.aliza.alizacomposes.wallet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray
import com.aliza.alizacomposes.wallet.data.MockData
import com.aliza.alizacomposes.wallet.data.MockData.createRandomFloatList
import com.aliza.alizacomposes.wallet.ui.theme.AppBackgroundLight
import com.aliza.alizacomposes.wallet.ui.theme.gradientBluePurple
import com.aliza.alizacomposes.wallet.ui.theme.gradientRedPurple

@Composable
fun ChartActivityWidget(pointData: List<Float>, months: ArrayList<String>) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .background(
                if (isSystemInDarkTheme()) AppDarkGray
                else AppBackgroundLight,
                RoundedCornerShape(25.dp)
            )
            .padding(top = 25.dp, bottom = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Activity",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(25.dp))
        ChartLine(
            yAxisValues = pointData,
            months = months,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            lineColors = if (isSystemInDarkTheme()) gradientRedPurple else gradientBluePurple
        )
    }
}

@Preview
@Composable
fun ChartActivityWidgetPrev() {
    ChartActivityWidget(createRandomFloatList(), MockData.months)
}