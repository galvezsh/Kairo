package com.galvezsh.kairo.presentation.screens.onboarding.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.kairo.R

@Composable
fun FeaturesPage() {

    Column(
        modifier = Modifier.fillMaxSize().padding( all = 24.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource( id = R.string.onboarding_features_title ),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer( modifier = Modifier.height( height = 32.dp ) )

        // Feature: Home
        FeatureItem(
            icon = Icons.Filled.Home,
            title = stringResource( id = R.string.tab_home ),
            description = stringResource( id = R.string.onboarding_feature_home )
        )

        Spacer( modifier = Modifier.height( height = 20.dp ) )

        // Feature: Tasks
        FeatureItem(
            icon = Icons.Filled.CalendarMonth,
            title = stringResource( id = R.string.tab_tasks ),
            description = stringResource( id = R.string.onboarding_feature_tasks )
        )

        Spacer( modifier = Modifier.height( height = 20.dp ) )

        // Feature: Statistics
        FeatureItem(
            icon = Icons.Filled.BarChart,
            title = stringResource( id = R.string.tab_statistics ),
            description = stringResource( id = R.string.onboarding_feature_statistics )
        )

        Spacer( modifier = Modifier.height( height = 20.dp ) )

        // Feature: Profile
        FeatureItem(
            icon = Icons.Filled.Person,
            title = stringResource( id = R.string.tab_profile ),
            description = stringResource( id = R.string.onboarding_feature_profile )
        )
    }
}

@Composable
private fun FeatureItem(
    icon: ImageVector,
    title: String,
    description: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size( size = 40.dp )
        )

        Column(
            modifier = Modifier.padding( start = 16.dp )
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
