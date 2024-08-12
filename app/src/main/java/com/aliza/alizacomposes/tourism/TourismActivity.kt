package com.aliza.alizacomposes.tourism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.tourism.ui.screens.TourismScreen
import com.aliza.alizacomposes.tourism.ui.theme.TourismTheme

class TourismActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TourismTheme {
                TourismScreen()
            }
        }
    }
}