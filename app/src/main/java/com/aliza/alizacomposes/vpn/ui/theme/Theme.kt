package com.aliza.alizacomposes.vpn.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
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

private object JetNewsRippleTheme : RippleTheme {
    // Here you should return the ripple color you want
    // and not use the defaultRippleColor extension on RippleTheme.
    // Using that will override the ripple color set in DarkMode
    // or when you set light parameter to false
    @Composable
    override fun defaultColor(): Color = Blue

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Blue,
        lightTheme = !isSystemInDarkTheme()
    )
}

@Composable
fun VpnTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity  = view.context as Activity
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                activity.window.navigationBarColor = NavyBlue.toArgb()
                activity.window.statusBarColor = Black.toArgb()
                WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = false
                WindowCompat.getInsetsController(activity.window, view).isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
    ){
        CompositionLocalProvider(
            LocalRippleTheme provides JetNewsRippleTheme,
            content = content
        )
    }
}