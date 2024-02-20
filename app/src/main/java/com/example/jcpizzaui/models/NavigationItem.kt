package com.example.jcpizzaui.models

import androidx.compose.ui.graphics.ImageBitmap

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageBitmap,
    val unSelectedIcon: ImageBitmap
) {
}