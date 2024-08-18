package com.aliza.alizacomposes.foods.ui.screen.chat

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aliza.alizacomposes.foods.model.Chat

@Composable
fun ChatsWidget(modifier: Modifier = Modifier, chatList: List<Chat>) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        reverseLayout = true
    ) {
        items(chatList) { chat ->
            ChatItem(chat = chat)
        }
    }
}