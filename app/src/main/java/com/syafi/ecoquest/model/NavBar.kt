package com.syafi.ecoquest.model

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBar(
    val title: String,
    @DrawableRes
    val icon: Int,
)
