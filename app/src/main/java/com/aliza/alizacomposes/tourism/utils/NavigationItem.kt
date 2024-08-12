package com.aliza.alizacomposes.tourism.utils

import androidx.annotation.DrawableRes
import com.aliza.alizacomposes.R

sealed class NavigationItem(var route: String, var title: String, @DrawableRes var icon: Int) {
    data object Home : NavigationItem("home", "Home", R.drawable.ic_home_tourism)
    data object Favorites : NavigationItem("favorite", "Favorite", R.drawable.ic_heart)
    data object Tickets : NavigationItem("tickets", "Tickets", R.drawable.ic_ticket)
    data object Profile : NavigationItem("profile", "Profile", R.drawable.ic_user)
}