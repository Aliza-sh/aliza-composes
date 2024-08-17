package com.aliza.alizacomposes.shoes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
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
        primary = AppDark,
        onPrimary = Color.White,
        primaryContainer = AppDark,
        onPrimaryContainer = AppDark,
        inversePrimary = AppDark,
        secondary = AppDark,
        onSecondary = Color.White,
        secondaryContainer = AppDark,
        onSecondaryContainer = Color.White,
        tertiary = AppDark,
        onTertiary = Color.White,
        tertiaryContainer = AppDark,
        onTertiaryContainer = Color.White,
        background = AppDark,
        onBackground = Color.White,
        surface = AppDark,
        onSurface = Color.White,
        surfaceVariant = AppDark,
        onSurfaceVariant = Color.White,
        surfaceTint = AppDark,
        inverseSurface = AppDark,
        inverseOnSurface = AppDark,
        error = Color.Red,
        onError = Color.White,
        errorContainer = AppDark,
        onErrorContainer = Color.White,
        outline = AppDark,
        outlineVariant = AppDark,
        scrim = AppDark,
        surfaceBright = AppDark,
        surfaceContainer = AppDark,
        surfaceContainerHigh = AppDark,
        surfaceContainerHighest = AppDark,
        surfaceContainerLow = AppDark,
        surfaceContainerLowest = AppDark,
        surfaceDim = AppDark,
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
fun ShoesTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity  = view.context as Activity
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                activity.window.navigationBarColor = AppDark.toArgb()
                activity.window.statusBarColor = AppDark.toArgb()
                WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = false
                WindowCompat.getInsetsController(activity.window, view).isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}