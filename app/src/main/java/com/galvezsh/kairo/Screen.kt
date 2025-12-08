package com.galvezsh.kairo

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object StartScreen : NavKey
@Serializable
data object MainScreen : NavKey
@Serializable
data object CreateTaskScreen : NavKey

@Serializable
data object HomeInnerScreen : NavKey
@Serializable
data object TasksInnerScreen : NavKey
@Serializable
data object StatisticsInnerScreen : NavKey
@Serializable
data object ProfileInnerScreen : NavKey
