package com.aliza.alizacomposes.income_expenditure.data

import com.aliza.alizacomposes.income_expenditure.model.Transaction

object MockData {
    private val transactionList = listOf(
        Transaction("App UI", "13.06.2022", +1200),
        Transaction("App Design", "16.06.2022", +700),
        Transaction("Host & Domain", "23.06.2022", -400),
        Transaction("Test", "28.06.2022", +350)
    )

    fun getTransactionList(): List<Transaction> {
        return List(100) { index ->
            val originalTransaction = transactionList[index % transactionList.size]
            originalTransaction.copy(
                title = "${originalTransaction.title} ${index / transactionList.size + 1}"
            )
        }
    }
}