package com.galvezsh.kairo.presentation.screens.start_screen

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Suppress("ParamsComparedByRef")
@Composable
fun StartScreen( windowSizeClass: WindowWidthSizeClass, navigateToMainScreen: () -> Unit ) {

    /* TODO: CHECK here in the DB if the user already marked the login method */

    when ( windowSizeClass ) {
        WindowWidthSizeClass.Compact -> { CompactLayout(
            onGoogleLogin = { /* TODO: Future login with Firebase */ },
            onGuestLogin = navigateToMainScreen
        )}
        WindowWidthSizeClass.Medium -> { MediumLayout(
            onGoogleLogin = { /* TODO: Future login with Firebase */ },
            onGuestLogin = navigateToMainScreen
        ) }
        WindowWidthSizeClass.Expanded -> { ExtendedLayout(
            onGoogleLogin = { /* TODO: Future login with Firebase */ },
            onGuestLogin = navigateToMainScreen
        ) }
    }
}