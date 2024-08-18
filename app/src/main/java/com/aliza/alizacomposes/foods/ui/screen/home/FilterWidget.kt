package com.aliza.alizacomposes.foods.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun FilterWidget(modifier: Modifier = Modifier, filterList: List<String>) {
    var selectedFilter by remember { mutableIntStateOf(0) }
    val unSelectColor = if (isSystemInDarkTheme()) AppDark else AppLight
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 25.dp)
    ) {
        items(filterList.size) {
            Text(
                text = filterList[it],
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    color = if (selectedFilter == it) AppDark else MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .background(
                        if (selectedFilter == it) AppYellow else unSelectColor,
                        RoundedCornerShape(15.dp)
                    )
                    .padding(16.dp)
                    .clickable { selectedFilter = it }
            )
        }
    }
}