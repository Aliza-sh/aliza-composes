package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.instagram.data.MockData.users
import com.aliza.alizacomposes.instagram.model.Post
import com.aliza.alizacomposes.instagram.model.Story
import com.aliza.alizacomposes.instagram.ui.theme.GrayLite

@Composable
fun StoryWidget(story: Story) {

    Column(modifier = Modifier.padding(top = 12.dp, start = 12.dp, bottom = 8.dp)) {
        Box {
            IsStory(story)
            if (story.isLive) {
                StoryLiveWidget(story)
                Text(
                    text = "LIVE",
                    color = Color.White,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .size(25.dp, 16.dp)
                        .background(Color(0xFFFF0077), RoundedCornerShape(3.dp))
                        .align(Alignment.BottomCenter)
                        .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(3.dp))
                )
            } else
                ProfileImage(story)
        }
        Text(
            text = story.username,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
    }
}

@Composable
private fun IsStory(story: Story) {
    if (story.isStory) {
        StoryCircleAround(3.dp, 86.dp)
    } else {
        Spacer(
            modifier = Modifier
                .size(86.dp)
                .border(1.5.dp, GrayLite, CircleShape)
        )
    }
}

@Composable
private fun ProfileImage(story: Story) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(story.profile)
            .crossfade(true)
            .build(),
        contentDescription = story.username,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(86.dp)
            .padding(6.dp)
            .border(1.dp, GrayLite, CircleShape)
            .background(GrayLite, CircleShape)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun StoryWidgetPrev() {
    StoryWidget(
        story = Story(
            6,
            "Tyrian",
            R.drawable.tyrian_lannister,
            true,
            true
        )
    )
}