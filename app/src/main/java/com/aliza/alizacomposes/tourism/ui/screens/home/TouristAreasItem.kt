package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.tourism.model.TouristArea
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray
import com.aliza.alizacomposes.tourism.ui.theme.AppLightGray
import com.aliza.alizacomposes.tourism.ui.theme.AppWhite

@Composable
fun TouristAreasItem(
    touristArea: TouristArea
) {
    Card(
        onClick = {},
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = touristArea.image),
                contentDescription = touristArea.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = touristArea.title, color = AppWhite,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 15.dp, start = 15.dp)
            )
            Text(
                text = "${touristArea.price}$",
                color = if(isSystemInDarkTheme()) AppLightGray else AppDarkGray,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 15.dp, end = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if(isSystemInDarkTheme()) AppDarkGray else AppLightGray)
                    .padding(5.dp)
            )
        }
    }
}

@Preview
@Composable
fun ItemTouristAreas() {
    TouristAreasItem(
        TouristArea("Paris", 120, R.drawable.paris),
    )
}