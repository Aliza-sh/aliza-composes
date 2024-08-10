package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.ui.graphics.Color

class StoryAnimationCircleParams {
     val totalArcs = 30
     val eachAngle = 360f / totalArcs.toFloat()
     val startDelayAmount = 13L
     val startDuration = 800
     val endDuration = (startDuration * 0.6f).toInt()
     val waitDelay: Long = 200
     val startColor = Color(0xFFF700FF)
     val endColor = Color(0xFFFFB700)
 }
