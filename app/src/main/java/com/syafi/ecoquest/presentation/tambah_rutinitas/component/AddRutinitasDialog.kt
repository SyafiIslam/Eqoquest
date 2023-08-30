package com.syafi.ecoquest.presentation.tambah_rutinitas.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.util.Routes

@Composable
fun AddRutinitasDialog(dialog: MutableState<Boolean>, navController: NavController) {
    Dialog(onDismissRequest = { dialog.value = false }) {
        Surface(
            modifier = Modifier
                .width(319.dp)
                .height(133.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            DialogUi(navController = navController)
        }
    }
}

@Composable
fun DialogUi(navController: NavController) {
    Column(
        Modifier
            .wrapContentWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = R.drawable.check,
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Berhasil ditambahkan",
            color = MaterialTheme.colors.dark,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Tekan di mana saja",
            color = MaterialTheme.colors.green,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                navController.popBackStack()
                navController.navigate(Routes.HOME)
            }
        )
    }
}