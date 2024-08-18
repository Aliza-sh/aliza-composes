package com.aliza.alizacomposes.foods.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.data.MockData.Companion.getFilterList
import com.aliza.alizacomposes.foods.data.MockData.Companion.getFoodList

@Composable
fun HomeScreen() {
    val filterList = getFilterList()
    val foodList = getFoodList()
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(24.dp))
        HeaderWidget()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "What's your\nfavorite dish?",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(horizontal = 25.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        SearchWidget()
        Spacer(modifier = Modifier.height(20.dp))
        FilterWidget(filterList = filterList)
        Spacer(modifier = Modifier.height(20.dp))
        PopularFoodWidget(foodList = foodList)
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}