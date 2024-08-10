package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.ui.theme.GrayLite

@Preview
@Composable
fun StoryUserWidget() {
    Column(Modifier.padding(top = 12.dp, start = 12.dp, bottom = 8.dp)){
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.my)
                    .crossfade(true)
                    .build(),
                contentDescription = "story.username",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(86.dp)
                    .padding(6.dp)
                    .border(1.dp, GrayLite, CircleShape)
                    .background(GrayLite, CircleShape)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(bottom = 4.dp, end = 4.dp)
                    .background(Color(0xFF1E85FF), CircleShape)
                    .size(28.dp)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .padding(4.dp)
                    .align(Alignment.BottomEnd)
            )

        }
        Text(
            text = "your story",
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}