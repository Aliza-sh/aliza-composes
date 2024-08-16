package com.aliza.alizacomposes.movies.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.movies.ui.components.BottomBar
import com.aliza.alizacomposes.movies.ui.components.HeaderApp
import com.aliza.alizacomposes.movies.ui.components.PopularMovies

@Composable
fun MoviesScreen() {
    Scaffold(
        bottomBar = { BottomBar()},
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            HeaderApp()
            PopularMovies()
        }
    }
}

@Preview
@Composable
fun MoviesScreenPrev(modifier: Modifier = Modifier) {
    MoviesScreen()
}