package com.syafi.ecoquest.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.sage
import com.syafi.ecoquest.util.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, afterSplashDestination: String= Routes.WELCOME) {

    var startAnim by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(afterSplashDestination)
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.icon_logo),
                contentDescription = "logo",
                Modifier
                    .size(100.dp)
                    .alpha(alphaAnim.value)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                Modifier
                    .alpha(alphaAnim.value)
            )
        }
    }
}