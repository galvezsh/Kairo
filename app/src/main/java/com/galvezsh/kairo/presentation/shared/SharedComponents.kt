package com.galvezsh.kairo.presentation.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.kairo.R
import com.galvezsh.kairo.Screen

data class TabItem(
    val route: Screen,
    val tabText: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun DebugText( text: String, modifier: Modifier = Modifier ) {

    Box( modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center ) {
        Column( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ) {
            Text( text = text )
        }
    }
}

@Composable
fun NavigationItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .clickable(
                onClick = onClick,
                indication = ripple( bounded = false, radius = 40.dp ),
                interactionSource = remember { MutableInteractionSource() }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size( size = 24.dp ),
            tint = if ( selected )
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
            color = if (selected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
fun NavigationBarWithFAB(
    tabs: List<TabItem>,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onCreateTask: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        tonalElevation = 0.dp,
        modifier = Modifier.fillMaxWidth().windowInsetsPadding( insets = NavigationBarDefaults.windowInsets )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding( top = 8.dp )
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // First tabs ( 0 and 1 )
            tabs.take( n = 2 ).forEachIndexed { index, tab ->

                NavigationItem(
                    icon = if ( selectedTab == index ) tab.selectedIcon else tab.unselectedIcon,
                    label = tab.tabText,
                    selected = selectedTab == index,
                    onClick = { onTabSelected(index) },
                    modifier = Modifier.weight( weight = 1f )
                )
            }

            // Central floating action button
            Box(
                modifier = Modifier.weight( weight = 1f ),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = onCreateTask,
                    modifier = Modifier.size( size = 40.dp ),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource( id = R.string.fab_create_task_desc ),
                        tint = Color.White,
                        modifier = Modifier.size( size = 30.dp )
                    )
                }
            }

            // Last tabs ( 2 and 3 )
            tabs.drop( n = 2 ).forEachIndexed { index, tab ->

                val actualIndex = index + 2
                NavigationItem(
                    icon = if ( selectedTab == actualIndex ) tab.selectedIcon else tab.unselectedIcon,
                    label = tab.tabText,
                    selected = selectedTab == actualIndex,
                    onClick = { onTabSelected(actualIndex) },
                    modifier = Modifier.weight( weight = 1f )
                )
            }
        }
    }
}