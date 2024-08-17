package com.aliza.alizacomposes.shoes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.shoes.data.MockData.Companion.getListShoes
import com.aliza.alizacomposes.shoes.ui.components.HeaderWidget
import com.aliza.alizacomposes.shoes.ui.components.ShoesListWidget

@Composable
fun ShoesScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            HeaderWidget()
            ShoesListWidget(listShoes = getListShoes())
        }
    }
}

@Preview
@Composable
fun ShoesScreenPrev() {
    ShoesScreen()
}