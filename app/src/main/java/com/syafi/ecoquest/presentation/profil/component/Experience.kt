package com.syafi.ecoquest.presentation.profil.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.presentation.component.CustomLinearProgressBar
import com.syafi.ecoquest.ui.theme.dark

@Composable
fun Experience() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        AsyncImage(
            model = R.drawable.diamond,
            contentDescription = "",
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column() {
            CustomLinearProgressBar(progress = .65f)
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "150/200",
                    color = MaterialTheme.colors.dark,
                    style = MaterialTheme.typography.subtitle2
                )
                Text(
                    text = "Experience",
                    color = MaterialTheme.colors.dark,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}