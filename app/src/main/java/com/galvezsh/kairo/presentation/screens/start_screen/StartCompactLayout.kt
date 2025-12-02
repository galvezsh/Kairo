package com.galvezsh.kairo.presentation.screens.start_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun StartCompactLayout() {

    Scaffold { innerPadding ->
        Box( modifier = Modifier.padding( paddingValues = innerPadding ), contentAlignment = Alignment.Center ) {
            Text( text = "Start Screen in compact layout", color = Color.Black  )
        }
    }
}