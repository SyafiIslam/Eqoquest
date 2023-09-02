package com.syafi.ecoquest.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.syafi.ecoquest.util.Routes

class LoginViewModel() : ViewModel() {

    val auth = FirebaseAuth.getInstance()

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    fun handleBlank(context: Context) {
        Toast.makeText(
            context,
            "Email atau password tidak boleh kosong",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun handleLogin(navController: NavController, context: Context) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        navController.popBackStack()
                        navController.navigate(Routes.HOME + "?email=${email}")
                    }
                }
            }
            .addOnFailureListener {
                email = ""
                password = ""
                Toast.makeText(
                    context,
                    "Email atau password salah. Coba ulang kembali",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}