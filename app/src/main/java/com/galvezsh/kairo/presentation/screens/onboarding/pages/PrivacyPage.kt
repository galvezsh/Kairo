package com.galvezsh.kairo.presentation.screens.onboarding.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.kairo.R

@Composable
fun PrivacyPage( onGoogleLogin: () -> Unit,  onGuestLogin: () -> Unit ) {

    Column(
        modifier = Modifier.fillMaxSize().padding( all = 24.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource( id = R.string.onboarding_privacy_title ),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer( modifier = Modifier.height( height = 16.dp ) )

        Text(
            text = stringResource( id = R.string.onboarding_privacy_message ),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )

        Spacer( modifier = Modifier.height( height = 32.dp ) )

        Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ) {

            // Online section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight( weight = 1f )
            ) {
                Text(
                    text = stringResource( id = R.string.onboarding_emoji_cloud ),
                    fontSize = 48.sp
                )
                Text(
                    text = stringResource( id = R.string.onboarding_mode_online ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer( modifier = Modifier.height( height = 4.dp ) )
                Text(
                    text = stringResource( id = R.string.onboarding_mode_online_desc ),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }

            // Offline section
            Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight( weight = 1f ) ) {
                Text(
                    text = stringResource( id = R.string.onboarding_emoji_phone ),
                    fontSize = 48.sp
                )
                Text(
                    text = stringResource( id = R.string.onboarding_mode_offline ),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer( modifier = Modifier.height( height = 4.dp ) )
                Text(
                    text = stringResource( id = R.string.onboarding_mode_offline_desc ),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer( modifier = Modifier.height( height = 48.dp ) )

        // Google login button
        Button(
            onClick = onGoogleLogin,
            modifier = Modifier.fillMaxWidth().height( height = 52.dp ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color( color = 0xFFEA4335 ),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape( size = 12.dp )
        ) {
            Text( text = stringResource( id = R.string.btn_google_login ) )
        }

        Spacer( modifier = Modifier.height( height = 12.dp ) )

        // Guest login button
        OutlinedButton(
            onClick = onGuestLogin,
            modifier = Modifier.fillMaxWidth().height( height = 52.dp ),
            shape = RoundedCornerShape( size = 12.dp )
        ) {
            Text( text = stringResource( id = R.string.btn_continue_offline ) )
        }
    }
}
