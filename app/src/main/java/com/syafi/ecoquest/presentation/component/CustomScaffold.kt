package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.ui.theme.dark

@Composable
fun CustomScaffold(
    showBottomBar: Boolean = false,
    showFab: Boolean = false,
    navController: NavController,
    onFabClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavBar(navController = navController)
            }
        },
        content = content,
        floatingActionButton = {
            if (showFab) {
                CircularButton(onClick = { onFabClick() }, icon = Icons.Default.Add)
            }
        }
    )
}