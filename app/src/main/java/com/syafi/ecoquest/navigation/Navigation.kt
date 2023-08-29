package com.syafi.ecoquest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syafi.ecoquest.presentation.home.HomeScreen
import com.syafi.ecoquest.presentation.login.LoginScreen
import com.syafi.ecoquest.presentation.splash.SplashScreen
import com.syafi.ecoquest.presentation.welcome.WelcomeScreen
import com.syafi.ecoquest.util.Routes

@Composable
fun Navigation(navController: NavHostController, afterSplashDestination: String) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.SPLASH) {
            SplashScreen(navController = navController, afterSplashDestination)
        }
        composable(Routes.WELCOME) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(Routes.LOGIN) {
            LoginScreen()
        }
    }
}