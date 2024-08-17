package com.aliza.alizacomposes.shoes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.shoes.model.Shoes
import com.aliza.alizacomposes.shoes.ui.theme.AppLight
import com.aliza.alizacomposes.shoes.ui.theme.AppLightAlpha
import com.aliza.alizacomposes.shoes.ui.theme.AppRed

@Composable
fun ShoesItem(shoes: Shoes, modifier: Modifier = Modifier) {

    var liked by remember { mutableStateOf(shoes.liked) }

    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(Color.Transparent),
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .padding(15.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .align(Alignment.BottomCenter)
                        .background(AppLight)
                        .padding(15.dp)
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Rate",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = shoes.rate.toString(),
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }

                    IconButton(
                        onClick = { liked = !liked },
                        modifier = Modifier
                            .background(AppLightAlpha, RoundedCornerShape(8.dp))
                            .size(28.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (liked) R.drawable.heart_fill else R.drawable.heart_empty
                            ),
                            contentDescription = "",
                            tint = if (liked) AppRed else Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(5.dp)
                                .clip(
                                    RoundedCornerShape(5.dp)
                                )
                        )
                    }

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(70.dp)
                            .height(40.dp)
                            .align(Alignment.BottomCenter)
                            .shadow(15.dp, CircleShape)
                    )
                    Image(
                        painter = painterResource(id = shoes.image),
                        contentDescription = shoes.name,
                        modifier = Modifier
                            .width(160.dp)
                            .rotate(45f)
                            .align(Alignment.TopCenter)
                            .padding(top = 65.dp, start = 25.dp)
                    )
                }
            }
            Text(
                text = shoes.name, color = Color.White, fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${shoes.price}$", color = AppLight, fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoesItemPrev(modifier: Modifier = Modifier) {
    ShoesItem(Shoes("X1080v12", 160, R.drawable.nb1, 4.8f, true))
}