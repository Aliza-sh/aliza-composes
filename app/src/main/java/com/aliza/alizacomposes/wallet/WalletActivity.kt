package com.aliza.alizacomposes.wallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.wallet.ui.WalletScreen
import com.aliza.alizacomposes.wallet.ui.theme.WalletTheme

class WalletActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletTheme {
                WalletScreen()
            }
        }
    }
}