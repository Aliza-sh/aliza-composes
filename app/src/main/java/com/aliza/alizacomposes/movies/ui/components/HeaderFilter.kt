package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.movies.ui.theme.AppDarkAlpha
import com.aliza.alizacomposes.movies.ui.theme.AppMenuGray

@Composable
fun HeaderFilter(filters: List<String>, modifier: Modifier = Modifier) {
    var selectedFilter by remember { mutableIntStateOf(0) }
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 45.dp, end = 45.dp)
            .clip(RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp))
            .background(AppDarkAlpha),
        horizontalArrangement = Arrangement.Center
    ) {
        item {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        }
        items(filters.size) { filter ->
            TextButton(onClick = { selectedFilter = filter }) {
                Text(
                    text = filters[filter],
                    color = if (selectedFilter == filter) Color.White else AppMenuGray,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                )
            }
        }
    }
}