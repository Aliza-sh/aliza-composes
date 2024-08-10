package com.aliza.alizacomposes.instagram.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.instagram.data.MockData.posts
import com.aliza.alizacomposes.instagram.data.MockData.stories

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val listState = rememberLazyListState()
    // Use derivedStateOf to check if the first item is visible
    val isFirstItemVisible by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopBarHome(scrollBehavior, isFirstItemVisible) },
    ) {
        LazyColumn(
            contentPadding = it,
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                LazyRow {
                    item { StoryUserWidget() }
                    items(stories) { story -> StoryWidget(story) }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.2.dp)
                        .background(Color.DarkGray)
                )
            }
            items(50) { index ->
                ListItem(
                    headlineContent = { Text("Item $index") },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}