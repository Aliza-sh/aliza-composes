package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.tourism.model.TouristArea
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@Composable
fun TouristAreasGridWidget(touristAreas: List<TouristArea>) {
    LazyStaggeredGrid(
        cells = StaggeredCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 60.dp)
    ) {
        items(touristAreas.size) {
            TouristAreasItem(touristAreas[it])
        }
    }
}

@Preview
@Composable
fun GridTouristAreasPrev() {
    val touristAreas = listOf(
        TouristArea("Paris", 120, R.drawable.paris),
        TouristArea("Rome", 150, R.drawable.rome),
        TouristArea("Tehran", 240, R.drawable.tehran),
        TouristArea("Spain", 180, R.drawable.spain),
        TouristArea("Bali", 170, R.drawable.bali),
        TouristArea("Hawaii", 250, R.drawable.hawaii)
    )
    TouristAreasGridWidget(touristAreas)
}