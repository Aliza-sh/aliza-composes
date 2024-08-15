package com.aliza.alizacomposes.my_os.data

//noinspection SuspiciousImport
import android.R
import com.aliza.alizacomposes.my_os.model.Feature
import com.aliza.alizacomposes.my_os.ui.theme.LightBlue1
import com.aliza.alizacomposes.my_os.ui.theme.LightBlue2
import com.aliza.alizacomposes.my_os.ui.theme.LightBlue3
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple1
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple2
import com.aliza.alizacomposes.my_os.ui.theme.LightPurple3
import com.aliza.alizacomposes.my_os.ui.theme.LightRed1
import com.aliza.alizacomposes.my_os.ui.theme.LightRed2
import com.aliza.alizacomposes.my_os.ui.theme.LightRed3
import com.aliza.alizacomposes.my_os.ui.theme.LightYellow1
import com.aliza.alizacomposes.my_os.ui.theme.LightYellow2
import com.aliza.alizacomposes.my_os.ui.theme.LightYellow3
import com.aliza.alizacomposes.my_os.ui.theme.NightBlue1
import com.aliza.alizacomposes.my_os.ui.theme.NightBlue2
import com.aliza.alizacomposes.my_os.ui.theme.NightBlue3
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple1
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple2
import com.aliza.alizacomposes.my_os.ui.theme.NightPurple3
import com.aliza.alizacomposes.my_os.ui.theme.NightRed1
import com.aliza.alizacomposes.my_os.ui.theme.NightRed2
import com.aliza.alizacomposes.my_os.ui.theme.NightRed3
import com.aliza.alizacomposes.my_os.ui.theme.NightYellow1
import com.aliza.alizacomposes.my_os.ui.theme.NightYellow2
import com.aliza.alizacomposes.my_os.ui.theme.NightYellow3

class MockData {
    companion object {
        private val list = listOf(
            Feature(
                "Calls",
                "Communicate",
                R.drawable.ic_menu_call,
                Pair(LightPurple1, NightPurple1),
                Pair(LightPurple2, NightPurple2),
                Pair(LightPurple3, NightPurple3)
            ),
            Feature(
                "Photo",
                "tap to view",
                R.drawable.ic_menu_gallery,
                Pair(LightRed1, NightRed1),
                Pair(LightRed2, NightRed2),
                Pair(LightRed3, NightRed3)
            ),
            Feature(
                "Camera",
                "tap to take",
                R.drawable.ic_menu_camera,
                Pair(LightYellow1, NightYellow1),
                Pair(LightYellow2, NightYellow2),
                Pair(LightYellow3, NightYellow3)
            ),
            Feature(
                "Map",
                "tap to locate",
                R.drawable.ic_menu_compass,
                Pair(LightBlue1, NightBlue1),
                Pair(LightBlue2, NightBlue2),
                Pair(LightBlue3, NightBlue3)
            ),
        )

        fun getFeature(): List<Feature> {
            return list
        }
    }
}