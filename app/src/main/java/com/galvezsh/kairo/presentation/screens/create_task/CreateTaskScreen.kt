package com.galvezsh.kairo.presentation.screens.create_task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateTaskScreen( windowSizeClass: WindowWidthSizeClass) {

    Scaffold { innerPadding ->
        Box( modifier = Modifier.padding( paddingValues = innerPadding )  ) {
            CompactLayout()
        }
    }
}