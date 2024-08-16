package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PopularMovies(modifier: Modifier = Modifier) {
    Column {
        PopularMoviesTitle()
    }
}

@Preview
@Composable
fun PopularMoviesPrev() {
    PopularMovies()
}