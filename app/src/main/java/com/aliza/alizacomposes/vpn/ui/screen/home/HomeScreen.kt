package com.aliza.alizacomposes.vpn.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.vpn.ui.theme.Black
import com.aliza.alizacomposes.vpn.ui.theme.NavyBlue

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Black, NavyBlue)))
    ) {
        HeaderMenu() {
            navController.popBackStack()
        }
        ConnectionButton()
        Spacer(modifier = Modifier.height(45.dp))
        SelectionButton(
            R.drawable.openvpn,
            "Open VPN",
            "Select Protocol",
            modifier = Modifier.padding( start = 25.dp, end = 25.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        SelectionButton(
            R.drawable.iran,
            "Iran",
            "Tehran",
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen(rememberNavController())
}