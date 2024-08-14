package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGreen
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGreenLight
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppRed
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppRedLight
import com.aliza.alizacomposes.tourism.ui.theme.AppDarkGray

@Composable
fun EarningSpendingWidget() {

    val colorContainerGreen = if (isSystemInDarkTheme()) AppGreenLight else AppGreen
    val colorContainerRed = if (isSystemInDarkTheme()) AppRedLight else AppRed

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        Modifier
            .fillMaxWidth()
            .padding(25.dp, 5.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(colorContainerGreen)
                    .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Earning", color = AppDarkGray, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$58,560",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(colorContainerRed)
                    .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Spending", color = AppDarkGray, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$20,000",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }

}

@Preview
@Composable
fun EarningSpendingWidgetPrev(modifier: Modifier = Modifier) {
    EarningSpendingWidget()
}