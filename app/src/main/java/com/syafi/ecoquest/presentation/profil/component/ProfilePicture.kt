package com.syafi.ecoquest.presentation.profil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R

@Composable
fun ProfilePicture(
    level: Int,
    image: Int,
    modifier: Modifier,
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = image,
            contentDescription = "profil_pic",
            Modifier
                .size(96.dp)
                .clip(CircleShape)
                .align(Alignment.Center)
        )
        LevelBox(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 15.dp),
            level = level
        )
    }
}

@Composable
fun LevelBox(
    modifier: Modifier,
    level: Int
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = R.drawable.kotak_xp,
            contentDescription = "",
            Modifier
                .size(30.dp)
                .align(Alignment.Center)
        )
        Text(
            text = level.toString(), color = Color.White,
            modifier = Modifier
                .align(Alignment.Center),
            style = MaterialTheme.typography.h5
        )
    }
}