package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppLightGray
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun HeaderWidget(modifier: Modifier = Modifier) {
    val backgroundHeader = if (isSystemInDarkTheme()) AppDark else AppLight
    Row(
        Modifier
            .fillMaxWidth()
            .background(backgroundHeader)
            .padding(top = 40.dp, bottom = 15.dp)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_chat), contentDescription = "User",
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = "Ali",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 16.sp,
                )
            )
            Text(
                text = "Online",
                fontSize = 12.sp,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    textAlign = TextAlign.Center,
                    color = AppLightGray,
                    fontSize = 12.sp,
                )
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = "Call",
                tint = AppYellow
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_more_vert_chat),
                contentDescription = "More",
                tint = AppLightGray
            )
        }
    }
}