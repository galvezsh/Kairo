package com.galvezsh.kairo

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen

@Serializable
object StartScreen: Screen
@Serializable
object MainScreen: Screen
@Serializable
object CreateTaskScreen: Screen

@Serializable
object HomeInnerScreen: Screen
@Serializable
object TasksInnerScreen: Screen
@Serializable
object StatisticsInnerScreen: Screen
@Serializable
object ProfileInnerScreen: Screen
