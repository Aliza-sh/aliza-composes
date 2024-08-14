package com.aliza.alizacomposes.income_expenditure.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizacomposes.income_expenditure.data.MockData.getTransactionList
import com.aliza.alizacomposes.income_expenditure.ui.components.EarningSpendingWidget
import com.aliza.alizacomposes.income_expenditure.ui.components.FilterWidget
import com.aliza.alizacomposes.income_expenditure.ui.components.HeaderWidget
import com.aliza.alizacomposes.income_expenditure.ui.components.MonthlyStatsWidget
import com.aliza.alizacomposes.income_expenditure.ui.components.TransactionListWidget

@Composable
fun IncAndExpScreen() {

    val filters = listOf("Week", "Month", "Year")

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            HeaderWidget()
            FilterWidget(filters)
            MonthlyStatsWidget()
            EarningSpendingWidget()
            TransactionListWidget(getTransactionList())
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IncAndExpScreenPrev() {
    IncAndExpScreen()
}