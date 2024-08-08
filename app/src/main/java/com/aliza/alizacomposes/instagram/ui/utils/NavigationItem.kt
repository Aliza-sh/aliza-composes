package com.aliza.alizacomposes.instagram.ui.utils

import com.aliza.alizacomposes.R

sealed class NavigationItem(var id: Int, var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem(1, "home", R.drawable.ic_home, "Home")
    data object Search : NavigationItem(2, "search", R.drawable.ic_search, "Search")
    data object Add : NavigationItem(3, "add", R.drawable.ic_add, "Add")
    data object Reels : NavigationItem(4, "reels", R.drawable.ic_reels, "Reels")
    data object Profile : NavigationItem(5, "profile", R.drawable.ic_person, "Profile")
}