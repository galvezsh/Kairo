package com.galvezsh.kairo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.galvezsh.kairo.presentation.screens.create_task.CreateTaskScreen
import com.galvezsh.kairo.presentation.screens.main.MainScreen
import com.galvezsh.kairo.presentation.screens.start.StartScreen
import com.galvezsh.kairo.presentation.shared.CreateTaskScreen
import com.galvezsh.kairo.presentation.shared.MainScreen
import com.galvezsh.kairo.presentation.shared.StartScreen
import com.galvezsh.kairo.ui.theme.KairoTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            KairoTheme( dynamicColor = true, darkTheme = isSystemInDarkTheme() ) {

                val windowSizeClass = calculateWindowSizeClass( activity = this ).widthSizeClass
                val rootBackStack = rememberNavBackStack(StartScreen)

                // Primary navigation controller
                NavDisplay(
                    backStack = rootBackStack,
                    transitionSpec = { // Enter animation
                        slideInHorizontally(
                            initialOffsetX = { it },
                            animationSpec = tween( durationMillis = 300 )
                        ) togetherWith slideOutHorizontally(
                            targetOffsetX = { -it },
                            animationSpec = tween( durationMillis = 300 )
                        )
                    },
                    popTransitionSpec = { // Back animation
                        slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween( durationMillis = 300 )
                        ) togetherWith slideOutHorizontally(
                            targetOffsetX = { it },
                            animationSpec = tween( durationMillis = 300 )
                        )
                    },
                    predictivePopTransitionSpec = { // Predictive back animation (the back gesture in Android 13 when swiping)
                        slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween( durationMillis = 300 )
                        ) togetherWith slideOutHorizontally(
                            targetOffsetX = { it },
                            animationSpec = tween( durationMillis = 300 )
                        )
                    },
                    entryProvider = entryProvider {

                        entry<StartScreen> {
                            StartScreen( windowSizeClass, rootBackStack )
                        }

                        entry<MainScreen> {
                            MainScreen( windowSizeClass, rootBackStack )
                        }

                        entry<CreateTaskScreen> {
                            CreateTaskScreen( windowSizeClass )
                        }
                    }
                )
            }
        }
    }
}