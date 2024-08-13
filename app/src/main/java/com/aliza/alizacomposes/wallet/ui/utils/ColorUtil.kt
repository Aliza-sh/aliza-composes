package com.aliza.alizacomposes.wallet.ui.utils

import android.graphics.Color
import java.util.*

class ColorUtil {
    companion object {
        fun getRandomColor(): Int {
            val rnd = Random()
            val low = 80
            val high = 200
            return Color.argb(
                255,
                rnd.nextInt(high - low) + low,
                rnd.nextInt(high - low) + low,
                rnd.nextInt(high - low) + low
            )
        }
    }
}