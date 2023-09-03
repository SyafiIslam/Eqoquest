package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.syafi.ecoquest.ui.theme.green

@Composable
fun ProgressUser() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 7.dp
        ) {
            Row(
                Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(80.dp)
                                .width(20.dp),
                            color = MaterialTheme.colors.green,
                            progress = 0.75f,
                            strokeWidth = 5.dp,
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.green,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "150 exp",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.green,
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                Column {
                    Text(
                        text = "Hebat!",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Kamu menyelesaikan",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "5 misi",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.green,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}