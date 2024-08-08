package com.aliza.alizacomposes.main

import androidx.activity.ComponentActivity
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.InstagramActivity

sealed class Apps(val image: Int, val activity: ComponentActivity) {
    data object Instagram : Apps(R.drawable.img_samplebanner, InstagramActivity())
}