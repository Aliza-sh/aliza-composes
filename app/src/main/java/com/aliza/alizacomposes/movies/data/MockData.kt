package com.aliza.alizacomposes.movies.data

import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.movies.model.Movie
import com.aliza.alizacomposes.movies.model.Slider

class MockData {
    companion object {
        private val sliderList = listOf(
            Slider(R.drawable.joker0),
            Slider(R.drawable.joker1),
            Slider(R.drawable.joker2),
            Slider(R.drawable.joker3)
        )
        fun getSliderList(): List<Slider> {
            return sliderList
        }

        private val moviesList = listOf(
            Movie(R.drawable.movie_1, 9.4f),
            Movie(R.drawable.movie_2, 8.4f),
            Movie(R.drawable.movie_3, 9.3f),
            Movie(R.drawable.movie_4, 8.8f),
            Movie(R.drawable.movie_5, 9.7f),
            Movie(R.drawable.movie_6, 9.1f),
            Movie(R.drawable.movie_7, 8.2f)
        )
        fun getMoviesList(): List<Movie> {
            return moviesList
        }
    }
}