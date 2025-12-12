package com.galvezsh.kairo.presentation.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Box( modifier = modifier, contentAlignment = Alignment.Center ) {
        Row( horizontalArrangement = Arrangement.spacedBy( space = 8.dp ) ) {
            repeat( times = pageCount ) { index ->
                Box(
                    modifier = Modifier
                        .size( size = if (currentPage == index) 10.dp else 8.dp )
                        .clip( shape = CircleShape )
                        .background(
                            color = if (currentPage == index)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.onSurface.copy( alpha = 0.3f )
                        )
                )
            }
        }
    }
}
