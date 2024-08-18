package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.foods.data.User
import com.aliza.alizacomposes.foods.model.Chat
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun ChatItem(modifier: Modifier = Modifier,chat: Chat) {

    val backgroundChat = if (isSystemInDarkTheme()) AppDark else AppLight
    val fromMe = chat.from == User.MyName

    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .padding(15.dp, 5.dp)
                .clip(
                    RoundedCornerShape(
                        15.dp,
                        15.dp,
                        if (fromMe) 2.dp else 15.dp,
                        if (fromMe) 15.dp else 2.dp
                    )
                )
                .align(if (fromMe) Alignment.CenterEnd else Alignment.CenterStart)
                .background(if (fromMe) AppYellow else backgroundChat),
        ) {
            Text(
                text = chat.text,
                color = if (fromMe) AppDark else MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ChatItemPre() {
    ChatItem(chat = Chat("Hossein", "bye"))
}