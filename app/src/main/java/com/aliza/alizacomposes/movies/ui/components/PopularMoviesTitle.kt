package com.aliza.alizacomposes.movies.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.movies.ui.theme.AppGray
import com.aliza.alizacomposes.movies.ui.theme.AppWhite

@Composable
fun PopularMoviesTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 25.dp, 25.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular Movies", color = AppWhite, fontSize = 21.sp,
            modifier = Modifier.weight(1f)
        )
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "View All",
                color = AppGray,
                fontSize = 14.sp,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight.Normal,
                )
            )
        }
    }
}