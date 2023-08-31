package com.syafi.ecoquest.presentation.komunitas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.syafi.ecoquest.data.komunitasList
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.presentation.home.component.MisiItem
import com.syafi.ecoquest.presentation.komunitas.component.CommunityItem

@Composable
fun CommunityScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn {
            items(komunitasList.size) {
                CommunityItem(community = komunitasList[it], it)
            }
        }
    }
}