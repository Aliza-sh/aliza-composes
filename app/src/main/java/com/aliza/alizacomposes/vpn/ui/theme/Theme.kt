package com.aliza.alizacomposes.vpn.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.R

private val DarkColorScheme =
    darkColorScheme(
        primary = NavyBlue,
        onPrimary = Color.White,
        primaryContainer = NavyBlue,
        onPrimaryContainer = NavyBlue,
        inversePrimary = NavyBlue,
        secondary = NavyBlue,
        onSecondary = Color.White,
        secondaryContainer = NavyBlue,
        onSecondaryContainer = Color.White,
        tertiary = NavyBlue,
        onTertiary = Color.White,
        tertiaryContainer = NavyBlue,
        onTertiaryContainer = Color.White,
        background = NavyBlue,
        onBackground = Color.White,
        surface = NavyBlue,
        onSurface = Color.White,
        surfaceVariant = NavyBlue,
        onSurfaceVariant = Color.White,
        surfaceTint = NavyBlue,
        inverseSurface = NavyBlue,
        inverseOnSurface = NavyBlue,
        error = Color.Red,
        onError = Color.White,
        errorContainer = NavyBlue,
        onErrorContainer = Color.White,
        outline = NavyBlue,
        outlineVariant = NavyBlue,
        scrim = NavyBlue,
        surfaceBright = NavyBlue,
        surfaceContainer = NavyBlue,
        surfaceContainerHigh = NavyBlue,
        surfaceContainerHighest = NavyBlue,
        surfaceContainerLow = NavyBlue,
        surfaceContainerLowest = NavyBlue,
        surfaceDim = NavyBlue,
    )

private val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun VpnTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}