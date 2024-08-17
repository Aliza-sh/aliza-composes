package com.aliza.alizacomposes.shoes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.shoes.ui.components.HeaderWidget

@Composable
fun ShoesScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            HeaderWidget()
        }
    }
}

@Preview
@Composable
fun ShoesScreenPrev() {
    ShoesScreen()
}