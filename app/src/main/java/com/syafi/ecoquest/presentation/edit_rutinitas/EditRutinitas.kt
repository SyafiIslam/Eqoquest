package com.syafi.ecoquest.presentation.edit_rutinitas

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.presentation.component.CircularButton
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.presentation.tambah_rutinitas.component.AddRutinitasDialog
import com.syafi.ecoquest.ui.theme.abu
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.util.Routes

@Composable
fun EditRutinitas(navController: NavController) {
    var rutinitas by remember {
        mutableStateOf("")
    }

    var openDialog = remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(Modifier.fillMaxWidth()) {
                CircularButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Routes.HOME)
                    },
                    icon = Icons.Default.ArrowBack
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Edit Rutinitas",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.dark
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Judul Kegiatan",
                color = MaterialTheme.colors.abu,
                style = MaterialTheme.typography.body1
            )
            CustomTextField(
                text = rutinitas,
                placeholder = "Judul",
                onValueChange = {
                    rutinitas = it
                }
            )
        }
        CustomButton(text = "Simpan", onClick = { openDialog.value = true })

        if (openDialog.value) {
            AddRutinitasDialog(dialog = openDialog, navController)
        }
    }
}