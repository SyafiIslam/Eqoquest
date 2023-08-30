package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.syafi.ecoquest.ui.theme.green

@Composable
fun CustomLinearProgressBar(
    color: Color = MaterialTheme.colors.green,
    progress: Float = 0f,
    backgroundColor: Color = Color.White
) {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape),
        color = color,
        backgroundColor = backgroundColor,
        progress = progress
    )
}