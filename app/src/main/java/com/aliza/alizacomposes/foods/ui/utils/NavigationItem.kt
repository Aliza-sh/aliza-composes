package com.aliza.alizacomposes.foods.ui.utils

import com.aliza.alizacomposes.R

sealed class NavigationItem(var id: Int, var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem(1, "home", R.drawable.ic_home, "Home")
    data object Basket : NavigationItem(2, "basket", R.drawable.ic_basket, "Basket")
    data object Chat : NavigationItem(3, "chat", R.drawable.ic_chat, "Chat")
    data object Explore : NavigationItem(5, "explore", R.drawable.ic_gallery, "Explore")
    data object Search : NavigationItem(4, "search", R.drawable.ic_search_food, "Search")
}