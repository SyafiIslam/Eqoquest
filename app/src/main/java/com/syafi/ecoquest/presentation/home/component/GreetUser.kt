package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.green

@Composable
fun GreetUser(nama: String) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Selamat datang,",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "${nama}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.green,
                fontWeight = FontWeight.SemiBold
            )
        }

        Box(
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
        ) {
            AsyncImage(
                model = R.drawable.profile_picture,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}