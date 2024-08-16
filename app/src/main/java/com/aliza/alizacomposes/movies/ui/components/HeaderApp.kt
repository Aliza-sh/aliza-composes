package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.movies.data.MockData.Companion.getSliderList

@Composable
fun HeaderApp() {
    val listSlider = getSliderList()
    Box(modifier = Modifier.fillMaxWidth()) {
        HeaderSlider(listSlider)
    }
}

@Preview
@Composable
fun HeaderAppPrev(modifier: Modifier = Modifier) {
    HeaderApp()
}