package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppDarkGray
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppSilver

@Composable
fun FilterWidget(filters: List<String>) {

    val colorContainerFilter = if (isSystemInDarkTheme()) AppDarkGray else AppSilver
    val colorSelectedFilter = if (isSystemInDarkTheme()) Color.Black else Color.White

    var selectedFilter by remember { mutableIntStateOf(0) }

    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(25.dp,0.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(colorContainerFilter)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(filters.size) {
            Card(
                onClick = { selectedFilter = it },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedFilter == it) colorSelectedFilter else Color.Transparent
                )
            ) {
                Text(
                    text = filters[it], textAlign = TextAlign.Center,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FilterWidgetPrev(modifier: Modifier = Modifier) {
    val filters = listOf("Week", "Month", "Year")
    FilterWidget(filters)
}