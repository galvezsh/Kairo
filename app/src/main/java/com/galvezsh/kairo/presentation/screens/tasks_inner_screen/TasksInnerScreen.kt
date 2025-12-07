package com.galvezsh.kairo.presentation.screens.tasks_inner_screen

import androidx.compose.ui.res.stringResource
import com.galvezsh.kairo.R

import androidx.compose.foundation.background
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.galvezsh.kairo.presentation.shared.DebugText

@Composable
fun TasksInnerScreen( windowSizeClass: WindowWidthSizeClass) {

    DebugText( text = stringResource( id = R.string.debug_tasks ), modifier = Modifier.background( Color.Gray ) )
}