package com.aliza.alizacomposes.foods.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.model.Food
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppLightGray
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun FoodItem(modifier: Modifier = Modifier, food: Food) {
    var selected by remember { mutableStateOf(food.selected) }
    val backgroundColor = if (isSystemInDarkTheme()) AppDark else AppLight
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        modifier = Modifier
            .width(230.dp)
            .height(300.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(backgroundColor)
                    .align(Alignment.BottomCenter)
                    .padding(15.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = food.title,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        textAlign = TextAlign.Center,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = food.description,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        textAlign = TextAlign.Center,
                        color = AppLightGray,
                        fontSize = 15.sp,
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "$${food.price}",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    IconButton(
                        onClick = { selected = !selected },
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (selected) AppYellow else Color.Black)
                            .size(40.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_basket),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = food.image),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }
}

@Preview
@Composable
private fun FoodItemPrev() {
    FoodItem(
        food = Food(
            "Piper Pizza",
            "Spicy Chicken, Cheese, Olives, Arugula",
            5.99f,
            true,
            R.drawable.pizza
        )
    )
}