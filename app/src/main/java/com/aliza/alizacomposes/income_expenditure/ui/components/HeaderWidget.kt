package com.aliza.alizacomposes.income_expenditure.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.income_expenditure.ui.theme.AppPurple
import com.aliza.alizacomposes.income_expenditure.ui.theme.Purple80

@Composable
fun HeaderWidget() {
    val txtColor = if (isSystemInDarkTheme()) Purple80 else AppPurple
    ConstraintLayout(
        constraintSet = constraintSet(),
        animateChanges = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = "$",
            fontSize = 24.sp,
            color = txtColor,
            modifier = Modifier.layoutId("txtDollar")
        )
        Text(
            text = "6,890",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color = txtColor,
            modifier = Modifier.layoutId("txtInventory")
        )
        Text(
            text = "June earning",
            fontSize = 18.sp,
            color = txtColor,
            modifier = Modifier.layoutId("txtUser")
        )
        Image(
            painter = painterResource(id = R.drawable.user_inc),
            contentDescription = "User",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(20))
                .layoutId("imgUser")
        )
    }
}

private fun constraintSet(): ConstraintSet {
    return ConstraintSet {
        val txtDollar = createRefFor("txtDollar")
        val txtInventory = createRefFor("txtInventory")
        val txtUser = createRefFor("txtUser")
        val imgUser = createRefFor("imgUser")

        constrain(txtDollar) {
            start.linkTo(parent.start)
            top.linkTo(txtInventory.top)
            bottom.linkTo(txtInventory.bottom)
        }
        constrain(txtInventory) {
            start.linkTo(txtDollar.end)
        }
        constrain(txtUser) {
            top.linkTo(txtInventory.bottom)
            start.linkTo(parent.start)
        }
        constrain(imgUser) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
fun HeaderWidgetPrev(modifier: Modifier = Modifier) {
    HeaderWidget()
}