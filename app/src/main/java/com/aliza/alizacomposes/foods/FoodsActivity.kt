package com.aliza.alizacomposes.foods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.foods.ui.screen.FoodsScreen
import com.aliza.alizacomposes.foods.ui.theme.FoodsTheme

class FoodsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodsTheme {
                FoodsScreen()
            }
        }
    }
}