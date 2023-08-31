package com.syafi.ecoquest.presentation.profil.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.model.Completed
import com.syafi.ecoquest.ui.theme.green

@Composable
fun CompletedItem(completedData: Completed) {
    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.green,
        modifier = Modifier.padding(bottom = 15.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.weight(1f)) {
                AsyncImage(
                    model = R.drawable.check_putih,
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = completedData.title, style = MaterialTheme.typography.subtitle2)
            }
            Text(text = "+${completedData.bonus} exp", style = MaterialTheme.typography.subtitle2)
        }
    }
}