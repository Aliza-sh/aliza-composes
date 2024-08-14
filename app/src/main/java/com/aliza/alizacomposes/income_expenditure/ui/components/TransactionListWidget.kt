package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.income_expenditure.data.MockData.getTransactionList
import com.aliza.alizacomposes.income_expenditure.model.Transaction
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppPurple
import com.aliza.alizacomposes.income_expenditure.ui.theme.Purple80
import com.aliza.alizacomposes.income_expenditure.ui.utils.ScrollDirection
import com.aliza.alizacomposes.income_expenditure.ui.utils.rememberDirectionalLazyListState

@Composable
fun TransactionListWidget(transactionList: List<Transaction>) {

    val lazyListState = rememberLazyListState()
    val directionalLazyListState = rememberDirectionalLazyListState(lazyListState)
    val targetValue = when (directionalLazyListState.scrollDirection) {
        ScrollDirection.Up -> -300f
        ScrollDirection.Down -> 300f
        else -> 300f
    }

    Scaffold(
        floatingActionButton = {
            TransactionFAB(lazyListState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .padding(horizontal = it.calculateTopPadding())
        ) {
            Text(
                text = "Week Transactions",
                fontSize = 18.sp,
                color = if (isSystemInDarkTheme()) Purple80 else AppPurple,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            LazyColumn(
                state = lazyListState,
            ) {
                items(transactionList) {transaction->
                    TransactionItem(transaction, targetValue)
                }
            }
        }
    }
}

@Preview
@Composable
fun TransactionListWidgetPrev() {
    TransactionListWidget(getTransactionList())
}