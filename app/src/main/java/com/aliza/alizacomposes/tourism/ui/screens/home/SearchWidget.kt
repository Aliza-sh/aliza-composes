package com.aliza.alizacomposes.tourism.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray
import com.aliza.alizacomposes.tourism.ui.theme.AppLightGray
import com.aliza.alizacomposes.tourism.ui.theme.AppRed

@Composable
fun SearchWidget() {
    var search by remember { mutableStateOf("") }
    val color = if(isSystemInDarkTheme()) AppDarkGray else AppLightGray
    OutlinedTextField(
        value = search, onValueChange = { search = it },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .padding(25.dp, 0.dp, 25.dp, 0.dp),
        placeholder = {
            Text(text = "Search")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            disabledContainerColor = color,
            unfocusedContainerColor = color,
            focusedBorderColor = color,
            unfocusedBorderColor = color,
            cursorColor = AppRed
        ),
        shape = RoundedCornerShape(15.dp),
        singleLine = true
    )
}

@Preview
@Composable
fun SearchWidgetPrev(modifier: Modifier = Modifier) {
    SearchWidget()
}