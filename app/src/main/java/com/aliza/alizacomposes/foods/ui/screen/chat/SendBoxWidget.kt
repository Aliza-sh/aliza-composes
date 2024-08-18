package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppDarkGray
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun SendBoxWidget(modifier: Modifier = Modifier) {
    val backgroundSendBox = if (isSystemInDarkTheme()) AppDark else AppLight
    val backgroundSend = if (isSystemInDarkTheme()) Color.Black else Color.White
    Row(
        modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(50))
            .background(backgroundSendBox)
            .padding(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            var message by remember { mutableStateOf("") }
            OutlinedTextField(
                value = message, onValueChange = { message = it },
                placeholder = {
                    Text(
                        text = "Write something",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = AppDarkGray
                        )
                    )
                },
                singleLine = false,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = AppYellow
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 100.dp)
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_attachment),
                    contentDescription = "Attachment",
                    tint = AppDarkGray
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))
                    .background(backgroundSend)
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_send_food),
                    contentDescription = "Send",
                    tint = AppYellow
                )
            }
        }
    }
}

@Preview
@Composable
private fun SendBoxWidgetPrev() {
    SendBoxWidget()
}