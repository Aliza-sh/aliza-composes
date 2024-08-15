package com.aliza.alizacomposes.my_os.ui.utils

//noinspection SuspiciousImport
import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliza.alizacomposes.my_os.model.Feature
import com.aliza.alizacomposes.my_os.ui.theme.AppGray
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple1
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple2
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple3
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple1
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple2
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple3

@Composable
fun FeatureBox(feature: Feature) {
    val isDarkTheme = isSystemInDarkTheme()
    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(
                colorTheme(
                    isDarkTheme,
                    feature.backgroundColor.first,
                    feature.backgroundColor.second
                )
            )
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val l1P1 = Offset(0f, 0.5f * height)
        val l1P2 = Offset(0.1f * width, 0.405f * height)
        val l1P3 = Offset(0.4f * width, 0.25f * height)
        val l1P4 = Offset(0.75f * width, 0.7f * height)
        val l1P5 = Offset(1.4f * width, -1f * height)

        val l2P1 = Offset(0f, 0.55f * height)
        val l2P2 = Offset(0.2f * width, 0.5f * height)
        val l2P3 = Offset(0.35f * width, 0.55f * height)
        val l2P4 = Offset(0.75f * width, 0.9f * height)
        val l2P5 = Offset(1.4f * width, -1f * height / 2f)

        val path1 = getPath(
            l1P1, l1P2, l1P3, l1P4, l1P5, width, height
        )
        val path2 = getPath(
            l2P1, l2P2, l2P3, l2P4, l2P5, width, height
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path1,
                colorTheme(
                    isDarkTheme,
                    feature.path1Color.first,
                    feature.path1Color.second
                )
            )
            drawPath(
                path2,
                colorTheme(
                    isDarkTheme,
                    feature.path2Color.first,
                    feature.path2Color.second
                )
            )
        }

        Text(
            text = feature.title,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(25.dp),
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = feature.subtitle,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp),
            fontSize = 14.sp,
            color = AppGray
        )
        Icon(
            painter = painterResource(id = feature.icon),
            contentDescription = "Icon",
            tint = Color.White,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        )
    }
}

@Composable
private fun getPath(
    point1: Offset,
    point2: Offset,
    point3: Offset,
    point4: Offset,
    point5: Offset,
    width: Int,
    height: Int
): Path {
    val path = Path().apply {
        moveTo(point1.x, point1.y)
        quadraticBezierTo(
            point1.x,
            point1.y,
            (point1.x + point2.x) / 2f,
            (point1.y + point2.y) / 2f
        )
        quadraticBezierTo(
            point2.x, point2.y,
            (point2.x + point3.x) / 2f,
            (point2.y + point3.y) / 2f
        )
        quadraticBezierTo(
            point3.x, point3.y,
            (point3.x + point4.x) / 2f,
            (point3.y + point4.y) / 2f
        )
        quadraticBezierTo(
            point4.x, point4.y,
            (point4.x + point5.x) / 2f,
            (point4.y + point5.y) / 2f
        )
        lineTo(width + 100f, height + 100f)
        lineTo(-100f, height + 100f)
        close()
    }
    return path
}

@Preview
@Composable
private fun FeatureBoxPrev() {
    val feature = Feature(
        "Calls",
        "Communicate",
        R.drawable.ic_menu_call,
        Pair(LightPurple1, NightPurple1),
        Pair(LightPurple2, NightPurple2),
        Pair(LightPurple3, NightPurple3)
    )
    FeatureBox(feature)
}