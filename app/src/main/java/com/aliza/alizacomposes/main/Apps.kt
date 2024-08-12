package com.aliza.alizacomposes.main

import androidx.activity.ComponentActivity
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.InstagramActivity
import com.aliza.alizacomposes.tourism.TourismActivity

sealed class Apps(val imageLight: Int,val imageDark: Int, val activity: ComponentActivity) {
    data object Instagram : Apps(R.drawable.instagram_light,R.drawable.instagram_dark, InstagramActivity())
    data object Tourism : Apps(R.drawable.tourist_light,R.drawable.tourist_dark, TourismActivity())
}