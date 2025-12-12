package com.galvezsh.kairo.presentation.screens.onboarding.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.kairo.R

@Composable
fun WelcomePage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding( all = 24.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource( id = R.mipmap.focus_tomato_foreground ),
            contentDescription = stringResource( id = R.string.onboarding_logo_desc ),
            modifier = Modifier.size( size = 200.dp )
        )

        Spacer( modifier = Modifier.height( height = 32.dp ) )

        Text(
            text = stringResource( id = R.string.onboarding_welcome_title ),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer( modifier = Modifier.height( height = 16.dp ) )

        Text(
            text = stringResource( id = R.string.onboarding_welcome_description ),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
    }
}
