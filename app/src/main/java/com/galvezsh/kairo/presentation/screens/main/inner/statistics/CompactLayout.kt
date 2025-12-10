package com.galvezsh.kairo.presentation.screens.main.inner.statistics

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.galvezsh.kairo.R
import com.galvezsh.kairo.presentation.shared.DebugText

@Composable
fun CompactLayout() {
    DebugText( text = stringResource( id = R.string.debug_statistics ), modifier = Modifier.background( Color.Gray ) )
}
