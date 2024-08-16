package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.movies.data.MockData.Companion.getSliderList

@Composable
fun HeaderApp() {
    val listSlider = getSliderList()
    val filters = listOf("Movies", "TV Shows", "Trailers")
    Box(modifier = Modifier.fillMaxWidth()) {
        HeaderSlider(listSlider)
        HeaderFilter(filters, modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Preview
@Composable
fun HeaderAppPrev(modifier: Modifier = Modifier) {
    HeaderApp()
}