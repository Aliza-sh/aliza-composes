package com.aliza.alizacomposes.vpn.ui.screen.login

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.vpn.ui.theme.Black
import com.aliza.alizacomposes.vpn.ui.theme.Blue
import com.aliza.alizacomposes.vpn.ui.theme.WhiteOpacity

@Composable
fun LoginScreen(navController: NavHostController) {

    var login by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp, 0.dp, 60.dp, 60.dp))
            .background(Black)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieLoadingWidget(context = LocalContext.current)
        Spacer(modifier = Modifier.height(20.dp))
        InputData()
        Spacer(modifier = Modifier.height(21.dp))
        LoadingButton(
            onClick = {
                login = true
                Handler(Looper.getMainLooper()).postDelayed({
                    login = false
                    navController.navigate("home")
                }, 5000)
            },
            loading = login,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(50)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        RegAndForg()
        OtherWayLogin()
    }
}

@Composable
private fun InputData() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Text(
        text = "Login",
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight.Black,
            fontSize = 32.sp,
            color = Color.White
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Username")
        },
        singleLine = true,
        shape = RoundedCornerShape(50),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
            cursorColor = Blue,
            unfocusedLabelColor = WhiteOpacity,
            unfocusedBorderColor = WhiteOpacity
        )
    )
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Password")
        },
        singleLine = true,
        shape = RoundedCornerShape(50),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
            cursorColor = Blue,
            unfocusedLabelColor = WhiteOpacity,
            unfocusedBorderColor = WhiteOpacity
        )
    )
}

@Composable
private fun RegAndForg() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Forget Password",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 12.sp,
                    color = WhiteOpacity
                )
            )
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Register",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 12.sp,
                    color = WhiteOpacity
                )
            )
        }
    }
}

@Composable
private fun OtherWayLogin() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Login By Google",
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "Login By Facebook",
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Image(
            painter = painterResource(id = R.drawable.twitter),
            contentDescription = "Login By Twitter",
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .padding(5.dp)
        )
    }
}

@Preview
@Composable
fun LoginScreenPrev(modifier: Modifier = Modifier) {
    LoginScreen(rememberNavController())
}