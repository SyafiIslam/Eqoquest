package com.syafi.ecoquest.presentation.peringkat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.data.peringkatList
import com.syafi.ecoquest.presentation.home.component.MisiItem
import com.syafi.ecoquest.presentation.peringkat.component.LeaderBoardItem
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.sage

@Composable
fun LeaderBoardScreen() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = "Peringkatmu",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.dark
        )
        Spacer(modifier = Modifier.height(10.dp))
        val userTrueList = peringkatList.filter { it.user }.sortedByDescending { it.exp }
        LazyColumn {
            items(userTrueList.size) {
                LeaderBoardItem(peringkat = userTrueList[it], 3)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Text(
            text = "Ranking User",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.dark
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(peringkatList.size) {
                LeaderBoardItem(peringkat = peringkatList[it], it)
                Spacer(modifier = Modifier.height(10.dp))
            }
            item() {
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Design() {
    LeaderBoardScreen()
}