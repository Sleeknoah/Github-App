package com.chimdike.home.ui.home.model

import androidx.annotation.DrawableRes
import com.chimdike.ui_compose.R

data class NavigationItem(
    val text: String,
    val selectedIcon:  Int,
    val unSelectedIcon: Int,
)

val navItems = listOf(
    NavigationItem(
        text = "Home",
        selectedIcon = R.drawable.home_selected,
        unSelectedIcon = R.drawable.home
    ),NavigationItem(
        text = "Repositories",
        selectedIcon = R.drawable.search_selected,
        unSelectedIcon = R.drawable.search_normal
    ),NavigationItem(
        text = "Users",
        selectedIcon = R.drawable.user_selected,
        unSelectedIcon = R.drawable.user
    ),
)