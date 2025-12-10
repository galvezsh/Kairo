package com.galvezsh.kairo.presentation.shared

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey

data class TabItem(
    val route: NavKey,
    val tabText: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
