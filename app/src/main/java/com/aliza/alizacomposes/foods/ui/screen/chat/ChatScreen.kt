package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Column {
        HeaderWidget()
    }
}

@Preview
@Composable
private fun ChatScreenPrev() {
    ChatScreen()
}