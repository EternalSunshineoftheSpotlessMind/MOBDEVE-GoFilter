package com.example.gofilter

import androidx.compose.ui.graphics.vector.ImageVector

//Data class for bottom navigation bar icons
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)