package com.aliza.alizacomposes.wallet.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.wallet.ui.theme.AppGray

@Composable
fun TotalBalanceWidget() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Total Balance", fontSize = 21.sp, color = AppGray)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "$54,869.00",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}