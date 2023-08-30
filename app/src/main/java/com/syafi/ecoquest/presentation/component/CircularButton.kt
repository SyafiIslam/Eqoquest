package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.syafi.ecoquest.ui.theme.dark

@Composable
fun CircularButton(
    color: Color= MaterialTheme.colors.dark,
    onClick: () -> Unit,
    icon: ImageVector
) {
    Button(
        onClick = {
            onClick()
        },
        Modifier
            .size(48.dp)
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "add",
            tint = Color.White
        )
    }
}