package com.syafi.ecoquest.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.presentation.component.NavBar
import com.syafi.ecoquest.presentation.home.component.MisiItem
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.grey

@Composable
fun Home(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
        },
        content = content
    )
}


@Composable
fun HomeScreen(
    navController: NavController,
) {
    Home(
        navController = navController
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Selamat datang,",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Bambang",
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
                                progress = 0.5f,
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

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Misi",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(misiList.size) {
                    MisiItem(misi = misiList[it], it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Design() {
//    Home()
}