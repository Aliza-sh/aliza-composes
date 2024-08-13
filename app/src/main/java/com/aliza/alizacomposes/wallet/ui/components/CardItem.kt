package com.aliza.alizacomposes.wallet.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray
import com.aliza.alizacomposes.wallet.model.CardModel
import com.aliza.alizacomposes.wallet.ui.utils.ColorUtil

@Composable
fun CardItem(cardData: CardModel) {

    val cardColor = remember { ColorUtil.getRandomColor() }

    var flipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = tween(durationMillis = 600),
        label = ""
    )
    val isBackVisible = rotation > 90f

    Card(
        modifier = Modifier
            .width(340.dp)
            .height(220.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12f * density
            },
        onClick = { flipped = !flipped },
        shape = RoundedCornerShape(16.dp)
    ) {

        if (isBackVisible) {
            BackCard(cardData, cardColor)
        } else {
            ForthCard(cardData, cardColor)
        }

    }

}

@Composable
fun ForthCard(cardData: CardModel, cardColor: Int) {
    Box(
        Modifier
            .width(340.dp)
            .height(220.dp)
            .background(Color(cardColor))
            .clip(RoundedCornerShape(15.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 15.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(text = "Debit Card", fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.master),
                contentDescription = "Master",
                Modifier.width(50.dp)
            )
        }
        Text(
            text = cardData.no,
            color = Color.Black,
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 5.dp, 5.dp, 20.dp)
                .align(Alignment.Center),
            textAlign = TextAlign.Center
        )
        Row(
            Modifier
                .fillMaxWidth()
                .background(if (isSystemInDarkTheme()) AppDarkGray else Color.Black)
                .padding(25.dp, 13.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = cardData.owner, color = Color.White, fontSize = 18.sp)
            Text(text = cardData.exp, color = Color.White, fontSize = 18.sp)
        }
    }

}

@Composable
private fun BackCard(cardData: CardModel, cardColor: Int) {
    Box(
        Modifier
            .width(340.dp)
            .height(220.dp)
            .background(Color(cardColor))
            .clip(RoundedCornerShape(15.dp))
            .graphicsLayer {
                rotationY = 180f
            }
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(68.dp)
                .padding(top = 16.dp)
                .graphicsLayer { rotationY = 9180f }
                .align(Alignment.TopCenter)
                .background(if (isSystemInDarkTheme()) AppDarkGray else Color.Black)
        )
        Image(
            painter = painterResource(id = R.drawable.card_symbol),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 18.dp, top = 18.dp)
                .size(52.dp)
        )
        Text(
            text = "CVC: ${cardData.CVC}",
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 18.dp, bottom = 18.dp)
        )

    }

}

private val cardColorPrev = ColorUtil.getRandomColor()
private val cardDataPrev = CardModel("3584 5478 5687 5522", "25/01", "Alireza shahsavari", 2020)

@Preview
@Composable
fun ForthCardPrev(modifier: Modifier = Modifier) {
    ForthCard(
        cardDataPrev, cardColorPrev
    )
}

@Preview
@Composable
fun BackCardPrev(modifier: Modifier = Modifier) {
    BackCard(cardDataPrev, cardColorPrev)
}

@Preview
@Composable
fun PreviewFlippableCard() {
    CardItem(cardDataPrev)
}