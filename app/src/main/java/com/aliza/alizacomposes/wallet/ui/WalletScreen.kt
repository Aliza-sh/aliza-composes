package com.aliza.alizacomposes.wallet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.wallet.data.MockData.cardList
import com.aliza.alizacomposes.wallet.ui.components.CardsWidget
import com.aliza.alizacomposes.wallet.ui.components.HeaderWidget

@Composable
fun WalletScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            HeaderWidget()
            Spacer(modifier = Modifier.height(25.dp))
            CardsWidget(cardList = cardList)
        }
    }
}

@Preview
@Composable
fun WalletScreenPrev() {
    WalletScreen()
}