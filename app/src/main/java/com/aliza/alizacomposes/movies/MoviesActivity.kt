package com.aliza.alizacomposes.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.movies.ui.MoviesScreen
import com.aliza.alizacomposes.movies.ui.theme.MoviesTheme

class MoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesTheme {
                MoviesScreen()
            }
        }
    }
}