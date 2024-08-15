package com.aliza.alizacomposes.my_os.model

import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    val subtitle: String,
    val icon: Int,
    val backgroundColor: Pair<Color,Color>,
    val path1Color: Pair<Color,Color>,
    val path2Color: Pair<Color,Color>
)