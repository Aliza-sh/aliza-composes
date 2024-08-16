package com.aliza.alizacomposes.movies.ui.utils

import androidx.annotation.DrawableRes
import com.aliza.alizacomposes.R

sealed class NavigationItem(var route: String, var title: String, @DrawableRes var icon: Int) {
    data object Home : NavigationItem("home", "Home", R.drawable.ic_home_movie)
    data object Movie : NavigationItem("movie", "Movie", R.drawable.ic_video_movie)
    data object Favorites : NavigationItem("favorite", "Favorite", R.drawable.ic_heart_movie)
    data object Profile : NavigationItem("profile", "Profile", R.drawable.ic_user_movie)
}