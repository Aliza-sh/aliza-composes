package com.aliza.alizacomposes.vpn.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.vpn.ui.theme.Black
import com.aliza.alizacomposes.vpn.ui.theme.WhiteOpacity

@Composable
fun HeaderMenu(modifier: Modifier = Modifier,onLogOutClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, WhiteOpacity),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            modifier = Modifier.size(50.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dashboard),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        DropMenuSetting(){onLogOutClick()}
    }
}

@Composable
fun DropMenuSetting(onLogOutClick: () -> Unit) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        OutlinedButton(
            onClick = { expanded = !expanded },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, WhiteOpacity),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            modifier = Modifier.size(50.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Black, RoundedCornerShape(20.dp))
                .border(1.dp, WhiteOpacity, RoundedCornerShape(20.dp))
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = "setting",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    )
                },
                onClick = { Toast.makeText(context, "setting", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Log Out",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    )
                },
                onClick = {
                    expanded = false
                    onLogOutClick()
                }
            )
        }
    }
}