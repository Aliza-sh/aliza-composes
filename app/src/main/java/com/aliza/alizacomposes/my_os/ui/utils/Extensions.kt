package com.aliza.alizacomposes.my_os.ui.utils

import androidx.compose.ui.graphics.Color

fun colorTheme(
    isDarkTheme: Boolean,
    colorLight: Color,
    colorDark: Color
): Color {
    return if (isDarkTheme)
        colorDark
    else
        colorLight
}