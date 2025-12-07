package com.galvezsh.kairo.presentation.screens.start_screen

import androidx.compose.ui.res.stringResource
import com.galvezsh.kairo.R

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ExtendedLayout( onGoogleLogin: () -> Unit, onGuestLogin: () -> Unit ) {

    Scaffold { innerPadding ->
        Box( modifier = Modifier.padding( paddingValues = innerPadding ), contentAlignment = Alignment.Center ) {
            Text( text = stringResource( id = R.string.debug_extended_layout ), color = Color.Black )
        }
    }
}