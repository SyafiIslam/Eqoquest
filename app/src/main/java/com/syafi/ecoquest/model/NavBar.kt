package com.syafi.ecoquest.model

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBar(
    val title: String,
    val icon: Painter,
    val route: String,
    val rootRoute: String
)
