package com.galvezsh.kairo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.galvezsh.kairo.presentation.screens.create_task_screen.CreateTaskScreen
import com.galvezsh.kairo.presentation.screens.main_screen.MainScreen
import com.galvezsh.kairo.presentation.screens.start_screen.StartScreen
import com.galvezsh.kairo.ui.theme.KairoTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        enableEdgeToEdge()
        setContent {

            KairoTheme( dynamicColor = true, darkTheme = isSystemInDarkTheme() ) {

                val windowSizeClass = calculateWindowSizeClass( activity = this ).widthSizeClass
                val rootNavController = rememberNavController()

                // Primary navigation controller
                NavHost(
                    navController = rootNavController,
                    startDestination = StartScreen,
                    enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
                    popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
                    popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
                ) {
                    composable<StartScreen> {
                        StartScreen( windowSizeClass ) {
                            rootNavController.navigate( route = MainScreen ) {
                                // This makes the new screen the root one, so if the user make a pop() call, the app will close immediately
                                popUpTo( id = rootNavController.graph.id ) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    }

                    composable<MainScreen> {
                        MainScreen( windowSizeClass, rootNavController )
                    }

                    composable<CreateTaskScreen> {
                        CreateTaskScreen( windowSizeClass )
                    }
                }
            }
        }
    }
}