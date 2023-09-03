package com.syafi.ecoquest.presentation.tambah_rutinitas

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.syafi.ecoquest.presentation.component.CircularButton
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.presentation.tambah_rutinitas.component.AddRutinitasDialog
import com.syafi.ecoquest.ui.theme.abu
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.util.Routes

@Composable
fun AddRutinitasScreen(navController: NavController, email: String) {

    val context = LocalContext.current

    var rutinitas by remember {
        mutableStateOf("")
    }

    var isSwithOn by remember {
        mutableStateOf(false)
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
                        navController.navigate(Routes.HOME + "?email+${email}")
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
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Buat daftar rutinitas untuk berkontribusi kepada lingkungan. Ayo beraksi!",
                style = MaterialTheme.typography.body1
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
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Bagikan ke komunitas?", style = MaterialTheme.typography.body1)
                Switch(checked = isSwithOn, onCheckedChange = { isSwithOn = it })
            }
        }
        CustomButton(text = "Simpan", onClick = {
            if (rutinitas == "") {
                Toast.makeText(context, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else {
                openDialog.value = true
            }
        })

        if (openDialog.value) {
            AddRutinitasDialog(dialog = openDialog, navController, email)
        }
    }
}
