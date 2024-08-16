package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aliza.alizacomposes.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.movies.ui.theme.AppMenuGray
import com.aliza.alizacomposes.movies.ui.theme.AppRed

@Composable
fun HeaderSliderTitle(modifier:Modifier =Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(50.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Available Now", fontSize = 14.sp, color = AppMenuGray)
            Text(text = "Watch Joker", fontSize = 21.sp, color = Color.White)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play_circle),
                contentDescription = "Play",
                modifier = Modifier.size(50.dp),
                tint = AppRed
            )
        }
    }
}
