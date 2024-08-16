package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.movies.data.MockData.Companion.getMoviesList

@Composable
fun PopularMovies(modifier: Modifier = Modifier) {
    val listMovies = getMoviesList()
    Column {
        PopularMoviesTitle()
        PopularMoviesList(listMovies)
    }
}

@Preview
@Composable
fun PopularMoviesPrev() {
    PopularMovies()
}