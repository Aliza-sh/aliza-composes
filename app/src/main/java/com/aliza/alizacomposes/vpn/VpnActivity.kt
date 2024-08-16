package com.aliza.alizacomposes.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.vpn.ui.screen.VpnScreen
import com.aliza.alizacomposes.vpn.ui.theme.VpnTheme

class VpnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VpnTheme {
                VpnScreen()
            }
        }
    }
}

