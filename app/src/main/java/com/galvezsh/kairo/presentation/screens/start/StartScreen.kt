package com.galvezsh.kairo.presentation.screens.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.galvezsh.kairo.presentation.shared.MainScreen

@Suppress("ParamsComparedByRef")
@Composable
fun StartScreen( windowSizeClass: WindowWidthSizeClass, rootBackStack: NavBackStack<NavKey>) {

    /* TODO: CHECK here in the DB if the user already marked the login method */

    Scaffold { innerPadding ->
        Box( modifier = Modifier.padding( paddingValues = innerPadding ) ) {

            CompactLayout(
                onGoogleLogin = {
                    /* TODO: Future login with Firebase */

                    // Clean the navigation list and adds the new screen, making the only one in the stack
                    rootBackStack.clear()
                    rootBackStack.add( MainScreen )
                },
                onGuestLogin = {
                    // Clean the navigation list and adds the new screen, making the only one in the stack
                    rootBackStack.clear()
                    rootBackStack.add( MainScreen )
                }
            )

//            In a future i will implement adaptative layouts with this scheme
//            when ( windowSizeClass ) {
//                WindowWidthSizeClass.Compact -> { CompactLayout(...) }
//                WindowWidthSizeClass.Medium -> { MediumLayout(...) }
//                WindowWidthSizeClass.Expanded -> { ExtendedLayout(...) }
//            }
        }
    }
}