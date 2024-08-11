package com.aliza.alizacomposes.main

import androidx.activity.ComponentActivity
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.InstagramActivity

sealed class Apps(val imageLight: Int,val imageDark: Int, val activity: ComponentActivity) {
    data object Instagram : Apps(R.drawable.instagram_light,R.drawable.instagram_dark, InstagramActivity())
}