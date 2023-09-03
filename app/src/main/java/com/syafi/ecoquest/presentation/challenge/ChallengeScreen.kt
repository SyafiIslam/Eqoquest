package com.syafi.ecoquest.presentation.challenge

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.presentation.component.CircularButton
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.sage
import com.syafi.ecoquest.util.Routes

@Composable
fun ChallengeScreen(navController: NavController, email: MutableState<String>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box {
            AsyncImage(
                model = R.drawable.challenge,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                CircularButton(
                    onClick = {
                        navController.navigate(Routes.HOME + "?email=${email.value}")
                    },
                    icon = Icons.Default.ArrowBack
                )
            }
        }
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Column {
                Text(
                    text = "Tote bag 3 hari",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.dark
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Menggunakan tote bag saat berbelanja dapat mengurangi plastik. Tote bag juga dapat digunakan berkali-kali. Selesaikan misi ini dalam 3 hari untuk mendapat exp.",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Normal
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Text(
                    text = "Manfaat",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.dark
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "- Mengurangi sampah plastik",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Normal
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(35.dp),
                        model = R.drawable.challenge_exp,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "10 exp",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.sage,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(39.dp),
                        model = R.drawable.challenge_timer,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "36 jam",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.sage,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            CustomButton(
                text = "Mulai",
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Routes.HOME + "?email=${email.value}")
                }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Design() {
//    ChallengeScreen()
//}