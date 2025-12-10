package com.galvezsh.kairo.presentation.screens.create_task

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.galvezsh.kairo.R
import com.galvezsh.kairo.presentation.shared.DebugText

@Composable
fun CompactLayout() {
    DebugText( text = stringResource( id = R.string.debug_create_task ) )
}