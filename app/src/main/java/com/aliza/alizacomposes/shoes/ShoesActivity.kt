package com.aliza.alizacomposes.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.shoes.ui.ShoesScreen
import com.aliza.alizacomposes.shoes.ui.theme.ShoesTheme

class ShoesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoesTheme {
                ShoesScreen()
            }
        }
    }
}