package com.aliza.alizacomposes.foods.model

import androidx.annotation.DrawableRes

data class Food(
    var title: String,
    var description: String,
    var price: Float,
    var selected: Boolean,
    @DrawableRes var image: Int
)