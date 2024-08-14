package com.aliza.alizacomposes.income_expenditure.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.income_expenditure.model.Transaction
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGray
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGreen
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGreenDark
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppGreenLight
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppRed
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppRedDark
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppRedLight

@Composable
fun TransactionItem(transaction: Transaction, targetValue: Float,) {

    val colorContainerGreen = if (isSystemInDarkTheme()) AppGreenLight else AppGreen
    val colorContainerRed = if (isSystemInDarkTheme()) AppRedLight else AppRed

    val animatedOffset = remember { Animatable(300f) }
    LaunchedEffect(Unit) {
        animatedOffset.snapTo(targetValue)
        animatedOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 600,
                easing = FastOutSlowInEasing
            )
        )
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .offset { IntOffset(x = 0, y = animatedOffset.value.toInt()) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(if (transaction.price >= 0) colorContainerGreen else colorContainerRed),
            contentAlignment = Alignment.Center
        ) {
            var icon = Icons.Default.KeyboardArrowDown
            if (transaction.price >= 0) {
                icon = Icons.Default.KeyboardArrowUp
            }
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
        Column(
            Modifier
                .padding(10.dp)
                .weight(1f)
        ) {
            Text(text = transaction.title, fontSize = 14.sp)
            Text(text = transaction.date, fontSize = 10.sp, color = AppGray)
        }
        Text(
            text = if (transaction.price >= 0) "+${transaction.price}$" else "${transaction.price}$",
            color = if (transaction.price >= 0) AppGreenDark else AppRedDark,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionItemPrev() {
    val transaction = Transaction("App UI", "13.06.2022", +1200)
    TransactionItem(transaction, 20f)
}