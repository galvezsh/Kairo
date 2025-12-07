package com.galvezsh.kairo.presentation.screens.home_inner_screen

import androidx.compose.foundation.background
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.galvezsh.kairo.presentation.shared.DebugText

@Composable
fun HomeInnerScreen( windowSizeClass: WindowWidthSizeClass ) {

    DebugText( text = "Home screen", modifier = Modifier.background( Color.Gray ) )
}