package com.galvezsh.kairo.presentation.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.kairo.R

@Preview( showBackground = true, showSystemUi = true )
@Composable
private fun Preview() {
    CompactLayout( onGoogleLogin = {}, onGuestLogin = {} )
}

@Composable
fun CompactLayout( onGoogleLogin: () -> Unit, onGuestLogin: () -> Unit ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding( all = 24.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Imagen ----------
        Image(
            painter = painterResource(id = R.mipmap.focus_tomato_foreground),
            contentDescription = "FocusTomato",
            modifier = Modifier.size(220.dp)
        )

        // ---------- Título ----------
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource( id = R.string.welcome_title ),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource( id = R.string.welcome_description ),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Chips ----------
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AssistChip(
                onClick = { /* Acción futura */ },
                label = { Text( text = stringResource( id = R.string.chip_sync ) ) }
            )

            AssistChip(
                onClick = { /* Acción futura */ },
                label = { Text( text = stringResource( id = R.string.chip_offline ) ) }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ---------- Botón Google ----------
        Button(
            onClick = onGoogleLogin,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEA4335),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
//                Icon(
//                    painter = painterResource( id = Icons.AutoMirrored.Default. ),
//                    contentDescription = "Google",
//                    modifier = Modifier.size(22.dp)
//                )
//                Spacer(modifier = Modifier.width(12.dp))
            Text( text = stringResource( id = R.string.btn_google_login ) )
        }

        // ---------- Botón Invitado ----------
        OutlinedButton(
            onClick = onGuestLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text( text = stringResource( id = R.string.btn_continue_offline ) )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}