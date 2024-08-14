package com.aliza.alizacomposes.income_expenditure.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.income_expenditure.ui.components.HeaderWidget

@Composable
fun IncAndExpScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            HeaderWidget()

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IncAndExpScreenPrev() {
    IncAndExpScreen()
}