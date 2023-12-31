package com.syafi.ecoquest.presentation.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState
import com.syafi.ecoquest.R
import com.syafi.ecoquest.presentation.component.CustomButton
import com.syafi.ecoquest.presentation.component.CustomTextField
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.util.Routes

@Composable
fun LoginScreen(navController: NavController) {
    var showPassword by remember {
        mutableStateOf(false)
    }

    val oneTapSignInState = rememberOneTapSignInState()

    val authenticated = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    val viewModel= viewModel<LoginViewModel>()

    OneTapSignInWithGoogle(
        state = oneTapSignInState,
        clientId = "845503892362-5g03tam8tnpkh67lhalfrhjjfsvbvq22.apps.googleusercontent.com",
        onTokenIdReceived = { token ->
            authenticated.value = true
            Log.d("infoToken", token)
        },
        onDialogDismissed = { msg ->
            Log.d("dismissed", msg)
        }
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = R.drawable.login_logo,
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.dark
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextField(
            text = viewModel.email,
            placeholder = "Email",
            label = "Email",
            onValueChange = { viewModel.email = it })
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            text = viewModel.password,
            placeholder = "Password",
            isPassword = true,
            onValueChange = { viewModel.password = it },
            trailingIcon = Icons.Filled.Visibility,
            label = "Password",
            showPassword = showPassword,
            onPasswordToggle = { showPassword = it }
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomButton(
            text = "Masuk",
            onClick = {

                if (viewModel.email == "" || viewModel.password == "") {
                    viewModel.handleBlank(context)
                } else {
                    viewModel.handleLogin(navController, context= context)

                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(
            text = "Google",
            color = Color.White,
            textColor = Color.Black,
            icon = R.drawable.google_icon,
            onClick = { oneTapSignInState.open() },
            enabled = !oneTapSignInState.opened
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum punya akun?",
                style = MaterialTheme.typography.body1,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Routes.REGISTER)
                    },
                text = "Daftar",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.green
            )
        }
    }
}