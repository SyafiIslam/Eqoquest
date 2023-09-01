package com.syafi.ecoquest.presentation.add_postingan

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.presentation.add_postingan.component.AddPostDialog
import com.syafi.ecoquest.presentation.component.CircularButton
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.presentation.tambah_rutinitas.component.AddRutinitasDialog
import com.syafi.ecoquest.ui.theme.abu
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.util.Routes

@Composable
fun AddPost(navController: NavController) {

    var post by remember {
        mutableStateOf("")
    }

    var openDialog = remember {
        mutableStateOf(false)
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(Modifier.fillMaxWidth()) {
                CircularButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Routes.KOMUNITAS)
                    },
                    icon = Icons.Default.ArrowBack
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Tambah Rutinitas",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.dark
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Apa yang anda pikirkan?",
                color = MaterialTheme.colors.abu,
                style = MaterialTheme.typography.body1
            )

            CustomTextField(
                text = post,
                placeholder = "Tulis...",
                onValueChange = {
                    post = it
                },
                minLine = 4,
                maxLine = 8,
            )
        }
        CustomButton(
            text = "Unggah",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = {
                openDialog.value = true
            }
        )

        if (openDialog.value) {
            AddPostDialog(navController, openDialog)
        }
    }
}