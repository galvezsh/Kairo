package com.galvezsh.kairo.presentation.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.galvezsh.kairo.presentation.screens.onboarding.components.PageIndicator
import com.galvezsh.kairo.presentation.screens.onboarding.pages.FeaturesPage
import com.galvezsh.kairo.presentation.screens.onboarding.pages.PrivacyPage
import com.galvezsh.kairo.presentation.screens.onboarding.pages.WelcomePage

@Composable
fun CompactLayout(
    onGoogleLogin: () -> Unit,
    onGuestLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState( pageCount = { 3 } )

    Column( modifier = modifier ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight( weight = 1f )
        ) { page ->
            when ( page ) {
                0 -> WelcomePage()
                1 -> FeaturesPage()
                2 -> PrivacyPage(
                    onGoogleLogin = onGoogleLogin,
                    onGuestLogin = onGuestLogin
                )
            }
        }

        PageIndicator(
            pageCount = 3,
            currentPage = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth().padding( all = 16.dp )
        )
    }
}
