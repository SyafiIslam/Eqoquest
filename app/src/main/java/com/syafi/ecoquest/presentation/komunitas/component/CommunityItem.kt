package com.syafi.ecoquest.presentation.komunitas.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.data.komunitasList
import com.syafi.ecoquest.model.Komunitas

@Composable
fun CommunityItem(community: Komunitas, index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(65.dp)
                            .clip(CircleShape)
                    ) {
                        AsyncImage(
                            model = community.image,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = community.name,
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.SemiBold
                            )
                            if (community.verif) {
                                Spacer(modifier = Modifier.width(5.dp))
                                AsyncImage(
                                    model = R.drawable.verified_badge,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Text(
                            text = "${community.exp} exp",
                            style = MaterialTheme.typography.body1,
                            color = Color.LightGray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = community.body)
            }
            if (community.level) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = R.drawable.level_up,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
        if (index != 0) {
            Divider(
                color = Color.LightGray,
                thickness = 1.dp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Design() {
    val komunitas = komunitasList[0]
    CommunityItem(community = komunitas, 0)
}