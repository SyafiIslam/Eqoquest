package com.syafi.ecoquest.presentation.hadiah

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.green

@Composable
fun RewardScreen() {
    Column(
        Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(model = R.drawable.hadiah_img, contentDescription = "")
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Upps!",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.green
        )
        Text(
            text = "Hadihnya masih kosong!",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.green
        )
    }
}