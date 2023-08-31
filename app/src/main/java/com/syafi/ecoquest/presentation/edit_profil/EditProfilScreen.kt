package com.syafi.ecoquest.presentation.edit_profil

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.ecoquest.presentation.component.CircularButton
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.R
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.ui.theme.abu
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.util.Routes

@Composable
fun EditProfilScreen(navController: NavController) {

    var nama by remember {
        mutableStateOf("Bambang Yeager")
    }

    var email by remember {
        mutableStateOf("bambangganteng@gmail.com")
    }

    Box(Modifier.padding(20.dp)) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Column() {
                    CircularButton(
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Routes.PROFIL)
                        },
                        icon = Icons.Default.ArrowBack
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Edit Profil",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.dark,
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                model = R.drawable.profile_picture, contentDescription = "profpic",
                Modifier
                    .size(100.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Edit foto profil",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.dark,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                },


            )
            Spacer(modifier = Modifier.height(15.dp))
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Nama",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.abu
                )
                CustomTextField(text = nama, placeholder = "Nama", onValueChange = { nama = it })
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.abu
                )
                CustomTextField(text = email, placeholder = "Email", onValueChange = { email = it })
            }
        }
        CustomButton(
            text = "Simpan",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}