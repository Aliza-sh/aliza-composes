package com.aliza.alizacomposes.foods.ui.screen.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.ui.theme.AppDark
import com.aliza.alizacomposes.foods.ui.theme.AppDarkGray
import com.aliza.alizacomposes.foods.ui.theme.AppLight
import com.aliza.alizacomposes.foods.ui.theme.AppYellow

@Composable
fun SearchWidget(modifier: Modifier = Modifier) {
    var search by remember { mutableStateOf("") }
    val color = if(isSystemInDarkTheme()) AppDark else AppLight
    OutlinedTextField(
        value = search, onValueChange = { search = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_food),
                contentDescription = "Search",
                tint = AppDarkGray,
                modifier = Modifier.size(24.dp)
            )
        },
        placeholder = {
            Text(
                text = "Search any food",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = AppDarkGray
                )
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            disabledContainerColor = color,
            unfocusedContainerColor = color,
            focusedBorderColor = color,
            unfocusedBorderColor = color,
            cursorColor = AppYellow
        ),
        shape = RoundedCornerShape(15.dp)
    )
}