package com.aliza.alizacomposes.wallet.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WalletScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = "Wallet",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun WalletScreenPrev() {
    WalletScreen()
}