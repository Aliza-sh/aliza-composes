package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R

@Composable
fun HeaderWidget() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(25.dp, 25.dp, 25.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Where would you like to travel?",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(0.8f)
        )
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "User Avatar",
            modifier = Modifier
                .weight(0.2f)
                .clip(RoundedCornerShape(50))
        )
    }
}