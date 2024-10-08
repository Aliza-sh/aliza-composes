package com.aliza.alizacomposes.shoes.model

import androidx.annotation.DrawableRes

data class Shoes(
    var name: String,
    var price: Int,
    @DrawableRes var image: Int,
    var rate: Float,
    var liked: Boolean
)
