package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray
import com.aliza.alizacomposes.tourism.ui.theme.AppLightGray
import com.aliza.alizacomposes.tourism.ui.theme.AppRed
import com.aliza.alizacomposes.tourism.ui.theme.AppWhite

@Composable
fun FilterWidget(filterList: List<String>) {

    var selectedFilterIndex by remember { mutableIntStateOf(0) }
    val containerColor = if (isSystemInDarkTheme()) AppDarkGray else AppLightGray
    val contentColor = if (isSystemInDarkTheme()) AppLightGray else AppDarkGray

    LazyRow(contentPadding = PaddingValues(horizontal = 25.dp)) {
        items(filterList.size) { index ->
            TextButton(
                onClick = { selectedFilterIndex = index },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (selectedFilterIndex == index) AppRed else containerColor,
                    contentColor = if (selectedFilterIndex == index) AppWhite else contentColor
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = filterList[index],
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Preview
@Composable
fun FilterWidgetPrev() {
    val filterList = listOf("All", "Flight", "Cruise", "Train", "Car", "Ship")
    FilterWidget(filterList)
}