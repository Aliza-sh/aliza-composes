package com.aliza.alizacomposes.movies.data

import com.aliza.alizacomposes.R
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
    }
}