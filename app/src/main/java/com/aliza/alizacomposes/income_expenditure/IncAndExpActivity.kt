package com.aliza.alizacomposes.income_expenditure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizacomposes.income_expenditure.ui.IncAndExpScreen
import com.aliza.alizacomposes.income_expenditure.ui.theme.IncAndExpTheme

class IncAndExpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IncAndExpTheme {
                IncAndExpScreen()
            }
        }
    }
}