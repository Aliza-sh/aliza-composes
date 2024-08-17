package com.aliza.alizacomposes.shoes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.shoes.model.Shoes
import com.aliza.alizacomposes.shoes.ui.theme.AppLight

@Composable
fun ShoesListWidget(listShoes: List<Shoes>,modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxHeight()) {
        Text(
            text = "Collections", color = AppLight,
            fontSize = 28.sp, textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 25.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(listShoes) {
                ShoesItem(shoes = it)
            }
        }
    }
}
