package com.aliza.alizacomposes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.main.MainScreen
import com.aliza.alizacomposes.main.theme.AlizaComposesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlizaComposesTheme {
                MainScreen()
            }
        }
    }
}