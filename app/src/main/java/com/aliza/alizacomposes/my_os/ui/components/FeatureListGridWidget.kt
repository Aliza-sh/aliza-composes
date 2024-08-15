package com.aliza.alizacomposes.my_os.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.my_os.model.Feature
import com.aliza.alizacomposes.my_os.ui.utils.FeatureBox

@Composable
fun FeatureListGridWidget(features: List<Feature>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(features) {feature ->
            Card(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)
                    .padding(8.dp)
            ) {
                FeatureBox(feature)
            }
        }
    }
}