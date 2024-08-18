package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.foods.data.MockData.Companion.getChatList

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    val chatList = getChatList()
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 118.dp)) {
        HeaderWidget()
        ChatsWidget(modifier = Modifier.weight(1f),chatList = chatList)
        SendBoxWidget()
    }
}

@Preview
@Composable
private fun ChatScreenPrev() {
    ChatScreen()
}