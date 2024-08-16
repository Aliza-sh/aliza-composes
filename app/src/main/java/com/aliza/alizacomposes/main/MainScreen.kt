package com.aliza.alizacomposes.main

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.main.theme.AlizaComposesTheme
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        val itemApps = listOf(
            Apps.Instagram,
            Apps.Tourism,
            Apps.Wallet,
            Apps.IncAndExp,
            Apps.MyOs,
            Apps.Movies,
            Apps.Vpn,
        )

        LazyStaggeredGrid(
            cells = StaggeredCells.Fixed(2),
            modifier = Modifier.padding(innerPadding)

        ) {
            items(itemApps.size) { index ->
                BannerApp(item = itemApps[index])
            }
        }
    }
}

@Composable
fun BannerApp(item: Apps) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        onClick = {
            val intent = Intent(context, item.activity::class.java)
            context.startActivity(intent)
        }
    ) {
        Image(
            painter = if (isSystemInDarkTheme()) painterResource(id = item.imageDark) else painterResource(id = item.imageLight),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlizaComposesTheme {
        MainScreen()
    }
}