package com.syafi.ecoquest.presentation.peringkat

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.green

@Composable
fun LeaderBoardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Peringkat",
            color = MaterialTheme.colors.green,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold
        )
        Box(Modifier.size(380.dp)) {

            AsyncImage(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(300.dp),
                model = R.drawable.ilustrasi_peringkat,
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Design() {
    LeaderBoardScreen()
}