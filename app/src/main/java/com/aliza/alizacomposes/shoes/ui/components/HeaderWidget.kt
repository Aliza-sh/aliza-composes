package com.aliza.alizacomposes.shoes.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R

@Composable
fun HeaderWidget(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo_shoes),
            contentDescription = "Logo",
            modifier = Modifier.size(40.dp),
            tint = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.menu_dots),
            contentDescription = "Menu",
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )
    }
}