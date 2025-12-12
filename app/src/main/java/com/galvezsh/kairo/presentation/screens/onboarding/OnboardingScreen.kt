package com.galvezsh.kairo.presentation.screens.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.galvezsh.kairo.R
import com.galvezsh.kairo.presentation.shared.MainScreen
import kotlinx.coroutines.launch

@Suppress("ParamsComparedByRef")
@Composable
fun OnboardingScreen(rootBackStack: NavBackStack<NavKey> ) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val googleMessage = stringResource( id = R.string.onboarding_google_coming_soon )

    Scaffold( snackbarHost = { SnackbarHost( hostState = snackbarHostState ) }) { innerPadding ->

        CompactLayout(
            modifier = Modifier.fillMaxSize().padding( paddingValues = innerPadding ),
            onGoogleLogin = {
                scope.launch {
                    snackbarHostState.showSnackbar( message = googleMessage )
                }
            },
            onGuestLogin = {
                rootBackStack.clear()
                rootBackStack.add( MainScreen )
            }
        )
    }
}
