package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CustomScaffold(
    showBottomBar: Boolean = false,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavBar(navController = navController)
            }
        },
        content = content
    )
}