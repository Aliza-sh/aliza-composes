package com.aliza.alizacomposes.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.instagram.ui.screens.InstagramScreen
import com.aliza.alizacomposes.instagram.ui.theme.InstagramTheme

class InstagramActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramTheme {
                InstagramScreen()
            }
        }
    }
}