package com.aliza.alizacomposes.vpn.ui.screen.home

import android.os.Handler
import android.os.Looper
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.vpn.ui.theme.Blue
import com.aliza.alizacomposes.vpn.ui.theme.Green
import com.aliza.alizacomposes.vpn.ui.theme.Red
import com.aliza.alizacomposes.vpn.ui.theme.WhiteOpacity
import com.aliza.alizacomposes.vpn.ui.utils.ConnectionStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ConnectionButton(modifier: Modifier = Modifier) {

    var status by remember { mutableStateOf(ConnectionStatus.Disconnect) }
    var isLoading by remember { mutableStateOf(true) }
    var color by remember { mutableStateOf(Blue) }
    var tailLength by remember { mutableFloatStateOf(50f) }
    var cycleDuration by remember { mutableIntStateOf(1000) }

    val generalDuration = 10000

    val coroutineScope = rememberCoroutineScope()

    when (status) {
        ConnectionStatus.Disconnect -> {
            coroutineScope.launch {
                color = Blue
                tailLength = 50f
                cycleDuration = 3000
                isLoading = false
                delay((generalDuration / 6).toLong())
                isLoading = true
            }
        }

        ConnectionStatus.Connecting -> {
            coroutineScope.launch {
                color = Red
                tailLength = 140f
                cycleDuration = generalDuration / 7
                isLoading = false
                delay((generalDuration / 7).toLong())
                isLoading = true
            }
        }

        ConnectionStatus.Connected -> {
            coroutineScope.launch {
                color = Green
                tailLength = 140f
                cycleDuration = generalDuration / 9
                isLoading = false
                delay((generalDuration / 9).toLong())
                isLoading = true
            }
        }
    }

    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    val animatedSize by animateFloatAsState(
        targetValue = tailLength,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    val animatedDuration by animateIntAsState(
        targetValue = cycleDuration,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        ) {
            CircleLoader(
                color = animatedColor,
                tailLength = animatedSize,
                cycleDuration = animatedDuration,
                modifier = Modifier
                    .size(220.dp)
                    .align(Alignment.Center),
                isVisible = isLoading,
            )
            IconButton(
                onClick = {
                    status = when (status) {
                        ConnectionStatus.Disconnect -> ConnectionStatus.Connecting
                        ConnectionStatus.Connecting -> ConnectionStatus.Connecting
                        ConnectionStatus.Connected -> ConnectionStatus.Disconnect
                    }
                    if (status == ConnectionStatus.Connecting) {
                        Handler(Looper.getMainLooper()).postDelayed({
                            status = ConnectionStatus.Connected
                        }, generalDuration.toLong())
                    }
                },
                enabled = status == ConnectionStatus.Connected || status == ConnectionStatus.Disconnect,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(200.dp)
                    .border(1.dp, WhiteOpacity, CircleShape)
                    .padding(50.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.power),
                    contentDescription = "Power",
                    tint = Color.White
                )
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val icon = when (status) {
                ConnectionStatus.Disconnect -> R.drawable.ic_gpp_bad
                ConnectionStatus.Connecting -> R.drawable.ic_sync
                ConnectionStatus.Connected -> R.drawable.ic_gpp_good
            }
            Icon(
                painter = painterResource(id = icon), contentDescription = "",
                modifier = Modifier.size(25.dp),
                tint = WhiteOpacity
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = status.name, color = WhiteOpacity, fontSize = 21.sp)
        }
    }
}

@Preview
@Composable
fun ConnectionButtonPrev() {
    ConnectionButton()
}