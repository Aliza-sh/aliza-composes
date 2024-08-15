package com.aliza.alizacomposes.my_os.ui.components

//noinspection SuspiciousImport
import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliza.alizacomposes.my_os.model.Feature
import com.aliza.alizacomposes.my_os.ui.theme.LightGreen1
import com.aliza.alizacomposes.my_os.ui.theme.LightGreen2
import com.aliza.alizacomposes.my_os.ui.theme.LightGreen3
import com.aliza.alizacomposes.my_os.ui.theme.NightGreen1
import com.aliza.alizacomposes.my_os.ui.theme.NightGreen2
import com.aliza.alizacomposes.my_os.ui.theme.NightGreen3
import com.aliza.alizacomposes.my_os.ui.utils.FeatureBox

@Composable
fun FeatureMainWidget() {

    val feature = Feature(
        "Music",
        "Tap to play",
        R.drawable.ic_media_play,
        Pair(LightGreen1, NightGreen1),
        Pair(LightGreen2, NightGreen2),
        Pair(LightGreen3, NightGreen3)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(185.dp)
            .padding(8.dp)
    ) {
        FeatureBox(feature)
    }
}

@Preview
@Composable
fun FeatureMainWidgetPrev() {
    FeatureMainWidget()
}