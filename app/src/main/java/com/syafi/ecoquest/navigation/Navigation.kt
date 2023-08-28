package com.syafi.ecoquest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Login") {

    }
}