package com.aliza.alizacomposes.wallet.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.wallet.data.MockData.cardList
import com.aliza.alizacomposes.wallet.model.CardModel

@OptIn( ExperimentalFoundationApi::class)
@Composable
fun CardsWidget(cardList: ArrayList<CardModel>) {
    val lazyState: LazyListState = rememberLazyListState()
    LazyRow(
        contentPadding = PaddingValues(25.dp),
        state = lazyState,
        flingBehavior  = rememberSnapFlingBehavior(lazyListState = lazyState),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(cardList.size) {
            CardItem(cardList[it])
        }
    }
}

@Preview
@Composable
fun CardsWidgetPrev(modifier: Modifier = Modifier) {
    CardsWidget(cardList)
}