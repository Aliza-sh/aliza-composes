package com.aliza.alizacomposes.my_os

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.my_os.ui.MyOsScreen
import com.aliza.alizacomposes.my_os.ui.theme.MyOsTheme

class MyOsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyOsTheme {
                MyOsScreen()
            }
        }
    }
}