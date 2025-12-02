package com.galvezsh.kairo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.galvezsh.kairo.presentation.screens.start_screen.StartCompactLayout
import com.galvezsh.kairo.presentation.screens.start_screen.StartExtendedLayout
import com.galvezsh.kairo.presentation.screens.start_screen.StartMediumLayout
import com.galvezsh.kairo.presentation.screens.start_screen.StartScreen
import com.galvezsh.kairo.ui.theme.KairoTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        enableEdgeToEdge()
        setContent {

            KairoTheme( dynamicColor = true, darkTheme = isSystemInDarkTheme() ) {

                val windowSizeClass = calculateWindowSizeClass( activity = this )
                val rootNavController = rememberNavController()
                val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavHost(
                    navController = rootNavController,
                    startDestination = StartScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    popEnterTransition = { EnterTransition.None },
                    popExitTransition = { ExitTransition.None }
                ) {
                    composable<StartScreen> {
                        when ( windowSizeClass.widthSizeClass ) {
                            WindowWidthSizeClass.Compact -> { StartCompactLayout() }
                            WindowWidthSizeClass.Medium -> { StartMediumLayout() }
                            WindowWidthSizeClass.Expanded -> { StartExtendedLayout() }
                        }
                    }
                }
            }
        }
    }
}