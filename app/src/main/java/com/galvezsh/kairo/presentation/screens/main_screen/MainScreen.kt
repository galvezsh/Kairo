 package com.galvezsh.kairo.presentation.screens.main_screen

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.galvezsh.kairo.CreateTaskScreen
import com.galvezsh.kairo.HomeInnerScreen
import com.galvezsh.kairo.ProfileInnerScreen
import com.galvezsh.kairo.R
import com.galvezsh.kairo.StatisticsInnerScreen
import com.galvezsh.kairo.TasksInnerScreen
import com.galvezsh.kairo.presentation.screens.home_inner_screen.HomeInnerScreen
import com.galvezsh.kairo.presentation.screens.profile_inner_screen.ProfileInnerScreen
import com.galvezsh.kairo.presentation.screens.statistics_inner_screen.StatisticsInnerScreen
import com.galvezsh.kairo.presentation.screens.tasks_inner_screen.TasksInnerScreen
import com.galvezsh.kairo.presentation.shared.NavigationBarWithFAB
import com.galvezsh.kairo.presentation.shared.TabItem

 @Suppress("ParamsComparedByRef")
@Composable
fun MainScreen( windowSizeClass: WindowWidthSizeClass, rootBackStack: NavBackStack<NavKey> ) {

    val innerBackStack = rememberNavBackStack( HomeInnerScreen )
    var selectedTab by rememberSaveable { mutableIntStateOf( value = 0 ) }  // ← State hoisting
    var isNavigatingForward by rememberSaveable { mutableStateOf( value = true ) }  // ← Track navigation direction
    val tabs = listOf(
        TabItem(
            route = HomeInnerScreen,
            tabText = stringResource( id = R.string.tab_home ),
            title = stringResource( id = R.string.title_home ),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        TabItem(
            route = TasksInnerScreen,
            tabText = stringResource( id = R.string.tab_tasks ),
            title = stringResource( id = R.string.title_tasks ),
            selectedIcon = Icons.Filled.CalendarMonth,
            unselectedIcon = Icons.Outlined.CalendarMonth
        ),
        TabItem(
            route = StatisticsInnerScreen,
            tabText = stringResource( id = R.string.tab_statistics ),
            title = stringResource( id = R.string.title_statistics ),
            selectedIcon = Icons.Filled.BarChart,
            unselectedIcon = Icons.Outlined.BarChart
        ),
        TabItem(
            route = ProfileInnerScreen,
            tabText = stringResource( id = R.string.tab_profile ),
            title = stringResource( id = R.string.title_profile ),
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )

    Scaffold(
        topBar = {
            if ( windowSizeClass == WindowWidthSizeClass.Compact )
                Row( modifier = Modifier
                        .fillMaxWidth()
                        .background( color = MaterialTheme.colorScheme.background )
                        .padding( horizontal = 16.dp, vertical = 8.dp )
                        .windowInsetsPadding( insets = TopAppBarDefaults.windowInsets ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy( space = 8.dp )
                ) {
                    Image(
                        painter = painterResource( id = R.drawable.ic_launcher_background ),
                        modifier = Modifier.size( size = 32.dp ),
                        contentDescription = null,
                    )

                    Text(
                        text = tabs[ selectedTab ].title,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
        },
        bottomBar = {
            if ( windowSizeClass == WindowWidthSizeClass.Compact )
                NavigationBarWithFAB(
                    tabs = tabs,
                    selectedTab = selectedTab,
                    onTabSelected = { newIndex ->
                        // Determine navigation direction based on tab indices
                        isNavigatingForward = newIndex > selectedTab
                        selectedTab = newIndex

                        // Clean the navigation list and adds the new screen, making the only one in the stack
                        innerBackStack.clear()
                        innerBackStack.add( tabs[ newIndex ].route )
                    },
                    onCreateTask = { rootBackStack.add( CreateTaskScreen ) }
                )
        }

    ) { innerPadding ->

        // Secondary navigation controller with directional animations
        NavDisplay(
            backStack = innerBackStack,
            modifier = Modifier.padding( paddingValues = innerPadding ),
            transitionSpec = {
                if ( isNavigatingForward ) {
                    // Navigating forward (left to right): Home → Tasks → Statistics → Profile
                    slideInHorizontally(
                        initialOffsetX = { it },  // Enter from right
                        animationSpec = tween( durationMillis = 300 )
                    ) togetherWith slideOutHorizontally(
                        targetOffsetX = { -it },  // Exit to left
                        animationSpec = tween( durationMillis = 300 )
                    )
                } else {
                    // Navigating backward (right to left): Profile → Statistics → Tasks → Home
                    slideInHorizontally(
                        initialOffsetX = { -it },  // Enter from left
                        animationSpec = tween( durationMillis = 300 )
                    ) togetherWith slideOutHorizontally(
                        targetOffsetX = { it },  // Exit to right
                        animationSpec = tween( durationMillis = 300 )
                    )
                }
            },
            entryProvider = entryProvider {

                entry<HomeInnerScreen> {
                    HomeInnerScreen( windowSizeClass )
                }

                entry<TasksInnerScreen> {
                    TasksInnerScreen( windowSizeClass )
                }

                entry<StatisticsInnerScreen> {
                    StatisticsInnerScreen( windowSizeClass )
                }

                entry<ProfileInnerScreen> {
                    ProfileInnerScreen( windowSizeClass )
                }
            }
        )
    }
}