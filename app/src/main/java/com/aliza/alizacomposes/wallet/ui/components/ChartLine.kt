package com.aliza.alizacomposes.wallet.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.wallet.data.MockData.months
import com.aliza.alizacomposes.wallet.ui.theme.gradientRedPurple
import kotlin.math.min

@Composable
fun ChartLine(
    modifier: Modifier = Modifier,
    lineColors: List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.primary
    ),
    pointRadius: Float = 8f,
    pointColor: Color = MaterialTheme.colorScheme.secondary,
    lineWidth: Float = 4f,
    yAxisValues: List<Float>,
    months: List<String>, // لیست ماه‌ها
    shouldAnimate: Boolean = true,
) {
    val yValues = remember { yAxisValues }
    val x = remember { Animatable(0f) }
    val xTarget = (yValues.size - 1).toFloat()
    val darkTheme = isSystemInDarkTheme()

    LaunchedEffect(Unit) {
        x.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = if (shouldAnimate) 500 else 0,
                easing = LinearEasing
            ),
        )
    }

    Canvas(modifier = modifier.padding(20.dp)) {
        val path = Path()
        val xBounds = Pair(0f, xTarget)
        val yBounds = getBounds(yValues)
        val scaleX = size.width / (xBounds.second - xBounds.first)
        val scaleY = size.height / (yBounds.second - yBounds.first)
        val yMove = yBounds.first * scaleY

        // رسم خط نمودار و دایره‌ها
        (0..min(yValues.size - 1, x.value.toInt())).forEach { value ->
            val xPos = value * scaleX
            val yPos = size.height - (yValues[value] * scaleY) + yMove
            if (value == 0) {
                path.moveTo(0f, yPos)
            } else {
                path.lineTo(xPos, yPos)
            }
            // رسم دایره تو پر
            drawCircle(
                color = if (darkTheme) Color.White else Color.Black,
                radius = pointRadius,
                center = Offset(xPos, yPos)
            )
        }
        drawPath(
            path = path,
            brush = Brush.linearGradient(lineColors),
            style = Stroke(width = lineWidth)
        )

        // رسم نام ماه‌ها
        val textPaint = android.graphics.Paint().apply {
            color = if (darkTheme) Color.White.toArgb() else Color.Black.toArgb()
            textSize = 32f
            textAlign = android.graphics.Paint.Align.CENTER
        }
        months.forEachIndexed { index, month ->
            val x = index * scaleX
            drawContext.canvas.nativeCanvas.drawText(
                month,
                x,
                size.height + 40f, // فاصله از محور x
                textPaint
            )
        }
    }
}

fun getBounds(list: List<Float>): Pair<Float, Float> {
    var min = Float.MAX_VALUE
    var max = -Float.MAX_VALUE
    list.forEach {
        min = min.coerceAtMost(it)
        max = max.coerceAtLeast(it)
    }
    return Pair(min, max)
}

@Preview(showBackground = true)
@Composable
fun ChartLinePrev(modifier: Modifier = Modifier) {

    val points = listOf(
        20f,15f,97f,21f,63f,5f,12f,14f,2f,63f,5f,23f
    )
    ChartLine(
        yAxisValues = points,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        months = months,
        lineColors = gradientRedPurple
    )
}