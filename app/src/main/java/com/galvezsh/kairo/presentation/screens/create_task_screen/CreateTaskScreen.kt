package com.galvezsh.kairo.presentation.screens.create_task_screen

import androidx.compose.ui.res.stringResource
import com.galvezsh.kairo.R

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.galvezsh.kairo.presentation.shared.DebugText

@Composable
fun CreateTaskScreen( windowSizeClass: WindowWidthSizeClass) {

    DebugText( text = stringResource( id = R.string.debug_create_task ) )
}