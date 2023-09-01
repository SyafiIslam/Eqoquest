package com.syafi.ecoquest.presentation.login

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.syafi.ecoquest.R
import com.syafi.ecoquest.model.UserData
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.presentation.register.RegisterViewModel
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.util.Routes

@Composable
fun RegisterScreen(navController: NavController) {

    var showPassword by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    val viewModel= viewModel<RegisterViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(200.dp),
            model = R.drawable.register_logo,
            contentDescription = "Gambar Register",
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Buat Akun",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.dark
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextField(
            text = viewModel.fullName,
            placeholder = "Nama Lengkap",
            label = "Nama Lengkap",
            onValueChange = {
                viewModel.fullName = it
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            text = viewModel.email,
            placeholder = "Email",
            label = "Email",
            onValueChange = {
                viewModel.email = it
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            text = viewModel.password,
            placeholder = "Kata Sandi",
            label = "Kata Sandi",
            isPassword = true,
            onValueChange = {
                viewModel.password = it
            },
            trailingIcon = Icons.Filled.Visibility,
            showPassword = showPassword,
            onPasswordToggle = {
                showPassword = it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomButton(
            text = "Daftar",
            onClick = {

                if (viewModel.email == "" || viewModel.fullName == "" || viewModel.password == "") {
                    viewModel.handleBlank(context)
                } else {
                    viewModel.handleRegister(navController, context)
                }
            }
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sudah punya akun?",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Routes.LOGIN)
                    },
                text = "Masuk",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.green,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
